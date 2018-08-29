package com.iflide.crawler.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.iflide.crawler.util.UserAgentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;
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

    public void handle(final String url) {
        try {
            logger.info("Start crawl: " + url);
            WebClient webClient = getHtmlUnitSpider();
            HtmlPage page = webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(15000);
            pagePipeline.save(extractor.getAllLinks(url, page.asXml()));
            pagePipeline.save(extractor.getText(url, page.asText()));
            logger.info("End crawl: " + url);
        } catch (Exception e) {
            logger.error("Error: " + e.getMessage());
        }
    }

    private WebClient getHtmlUnitSpider() {
        // new webclient and initialize configure
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setTimeout(35000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.addRequestHeader("User-Agent",UserAgentUtils.getOneRandom());
        return webClient;
    }
}
