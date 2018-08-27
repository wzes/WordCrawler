package com.iflide.crawler.service;

import com.iflide.crawler.model.Url;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Service
public class CrawlerSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public static final String QUEUE_NAME = "iflide-crawler";

    public void send(Url url) {
        this.rabbitTemplate.convertAndSend(QUEUE_NAME, url);
    }

}
