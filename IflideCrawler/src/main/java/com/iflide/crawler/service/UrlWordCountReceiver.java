package com.iflide.crawler.service;

import com.iflide.crawler.config.RabbitConfig;
import com.iflide.crawler.model.Url;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_PAGE_INFO_NAME)
public class UrlWordCountReceiver {

    @RabbitHandler
    public void process(Url url) {
        System.out.println("Receiver  : " + url.getName());
    }

}
