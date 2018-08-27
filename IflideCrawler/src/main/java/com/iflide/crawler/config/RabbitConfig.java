package com.iflide.crawler.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "iflide-crawler";

    @Bean
    public Queue generateQueue() {
        return new Queue(QUEUE_NAME);
    }
}
