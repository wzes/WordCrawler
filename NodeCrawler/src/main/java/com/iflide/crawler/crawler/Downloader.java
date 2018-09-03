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
                    .header("Cookie", "remember_user_token=W1s3MTE3NjQxXSwiJDJhJDEwJEhwQ2h5S0M5UWY4QlplZDIzOWttVy4iLCIxNTM1MTg1MTg0Ljc2NTUwNDQiXQ%3D%3D--7b6a1aff6097525b81bbb0ea2e66d26fbfca0862; read_mode=day; default_font=font2; locale=zh-CN; _m7e_session=5fb91a94c3fee948476b830cbdec7a5f; Hm_lvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1535600549,1535711544,1535966790,1535967220; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%227117641%22%2C%22%24device_id%22%3A%2216499567e2cbad-0f93690aed106f-1e2e130c-2073600-16499567e2e10a3%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.baidu.com%2Flink%22%2C%22%24latest_referrer_host%22%3A%22www.baidu.com%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_utm_source%22%3A%22recommendation%22%2C%22%24latest_utm_medium%22%3A%22pc_all_hots%22%2C%22%24latest_utm_campaign%22%3A%22maleskine%22%2C%22%24latest_utm_content%22%3A%22note%22%7D%2C%22first_id%22%3A%2216499567e2cbad-0f93690aed106f-1e2e130c-2073600-16499567e2e10a3%22%7D; Hm_lpvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1535979318")
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
            atomicLong.decrementAndGet();
            logger.error("Crawl Exception: " + e.getMessage());
        }
    }
}
