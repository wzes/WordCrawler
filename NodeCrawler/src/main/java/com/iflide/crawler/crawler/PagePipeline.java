package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;
import com.iflide.crawler.service.CrawlerSender;
import com.iflide.crawler.service.UrlHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class PagePipeline extends Pipeline {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private static final String DIR_NAME = "data/";

    @Autowired
    CrawlerSender crawlerSender;

    /**
     * @param urls a list of urls
     */
    @Override
    public void save(List<Url> urls) {
        // send url info to service center
        crawlerSender.send(urls);
    }

    /**
     * @param url     url
     * @param content page content
     */
    @Override
    public void save(String url, String content) {
        // send url info to service center
        crawlerSender.send(new Url(url, content.length()));
        logger.info("Send url: " + url);

        //
        String domainName = UrlHelper.getDomainName(url);
        File file = new File(DIR_NAME + domainName);
        if (!file.exists() && !file.mkdirs()) {
            logger.error("file cannot create");
            return;
        }
        String filename = DIR_NAME + domainName + "/" + url.hashCode() + ".txt";
        try (FileWriter writer = new FileWriter(new File(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
