package com.iflide.crawler.service;

import com.iflide.crawler.model.Url;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Service
public class CrawlerSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static final String QUEUE_PAGE_INFO_NAME = "iflide-crawler-page-info";

    private static final String QUEUE_URL_UPLOAD_NAME = "iflide-crawler-url-upload";

    /**
     * <p>Upload a url include wordcount</p>
     *
     * @param url
     */
    public void send(Url url) {
        this.rabbitTemplate.convertAndSend(QUEUE_PAGE_INFO_NAME, url);
    }

    /**
     * <p>Upload outgoing urls</p>
     * @see Url
     *
     * @param urls a list of url
     */
    public void send(List<Url> urls) {
        this.rabbitTemplate.convertAndSend(QUEUE_URL_UPLOAD_NAME, urls);
    }
}
