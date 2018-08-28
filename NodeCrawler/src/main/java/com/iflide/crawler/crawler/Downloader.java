package com.iflide.crawler.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.iflide.crawler.util.UserAgentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

    public void handle(final String url) {
        GlobalTask.INSTANCE.mDefaultPool.execute(() -> {
            try {
                HtmlPage page = getHtmlUnitSpider().getPage(url);
                pagePipeline.save(extractor.getAllLinks(url, page.asXml()));
                pagePipeline.save(extractor.getText(url, page.asText()));
                logger.info("Crawler: " + url);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Error: " + e.getMessage());
            }
        });
    }

    private WebClient getHtmlUnitSpider() {
        // new webclient and initialize configure
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.addRequestHeader("User-Agent", UserAgentUtils.getOneRandom());
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        return webClient;
    }
}
