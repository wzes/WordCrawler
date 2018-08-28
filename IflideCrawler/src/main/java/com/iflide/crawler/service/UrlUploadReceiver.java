package com.iflide.crawler.service;

import com.iflide.crawler.config.RabbitConfig;
import com.iflide.crawler.model.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_URL_UPLOAD_NAME)
public class UrlUploadReceiver {
    ///////////////////////////////////////////////////////////////////////////
    // Url upload receiver
    ///////////////////////////////////////////////////////////////////////////

    @Autowired
    CleanerService cleanerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RabbitHandler
    public void process(List<Url> urls) {
        logger.info("Receive urls and the size is: " + urls.size());
        cleanerService.handle(urls);
    }
}
