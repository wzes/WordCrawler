package com.iflide.crawler.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_PAGE_INFO_NAME = "iflide-crawler-page-info";

    public static final String QUEUE_URL_UPLOAD_NAME = "iflide-crawler-url-upload";

    @Bean
    public Queue generateQueue() {
        return new Queue(QUEUE_PAGE_INFO_NAME);
    }

    @Bean
    public Queue generateUrlQueue() {
        return new Queue(QUEUE_URL_UPLOAD_NAME);
    }
}
