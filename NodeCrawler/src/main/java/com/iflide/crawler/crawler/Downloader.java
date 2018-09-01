package com.iflide.crawler.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.iflide.crawler.model.Url;
import com.iflide.crawler.util.UserAgentUtils;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class Downloader {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    Extractor extractor;

    @Autowired
    PagePipeline pagePipeline;

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    public void handle(final String url, final AtomicLong atomicLong) {
        try {
            logger.info("Start crawl: " + url);
            Request request = new Request.Builder()
                    .url(url)
                    .header("User-Agent", UserAgentUtils.getOneRandom())
                    .get()
                    .build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    // retry
                    //  pagePipeline.retry(new Url(url));
                    logger.info("Failure crawl: " + url);
                    atomicLong.decrementAndGet();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String content = response.body().string();
                    pagePipeline.save(extractor.getAllLinks(url, content));
                    pagePipeline.save(extractor.getText(url, content));
                    logger.info("End crawl: " + url);
                    atomicLong.decrementAndGet();
                }
            });
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
        }
    }
}
