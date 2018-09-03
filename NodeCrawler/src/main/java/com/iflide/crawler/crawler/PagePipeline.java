package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;
import com.iflide.crawler.service.CrawlerSender;
import com.iflide.crawler.service.UrlHelper;
import com.iflide.crawler.util.StringUtils;
import com.iflide.crawler.word.WordSplitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public void retry(Url url) {
        crawlerSender.send(Arrays.asList(url));
    }

    /**
     * @param url url
     */
    @Override
    public void save(Url url) {
        // send url info to service center
        crawlerSender.send(new Url(url.getName(), url.getContent().length()));
        logger.info("Send url: " + url.getName());
        if (url.getContent().length() == 0) {
            return;
        }
        // ensure file exist or create
        String domainName = UrlHelper.getDomainName(url.getName());
        File file = new File(DIR_NAME + domainName);
        if (!file.exists() && !file.mkdirs()) {
            logger.error("file cannot created");
            return;
        }
        // write content
        String filename = DIR_NAME + domainName + "/" + url.hashCode() + ".txt";
        try (FileWriter writer = new FileWriter(new File(filename))) {
            writer.write(url.getContent());
//            WordSplitter wordSplitter = new WordSplitter();
//            logger.info("Word splitter: " + url.getName() + " Size: " + url.getContent().length());
//            Map<String, Integer> wordMap = wordSplitter.handle(url.getContent());
//            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
//                if (StringUtils.isChinese(entry.getKey())) {
//                    writer.write(String.format("%s %s\n", entry.getKey(),
//                            entry.getValue()));
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
