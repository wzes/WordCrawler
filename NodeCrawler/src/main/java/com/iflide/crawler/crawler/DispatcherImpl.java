package com.iflide.crawler.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class DispatcherImpl implements Dispatcher {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final RestTemplate client = new RestTemplate();

    @Value("${iflide.url.address}")
    private String url;

    @Override
    public String getUrl() {
        String response = client.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class).toString();
        logger.info("Get url: " + response);
        return "null".equals(response) ? null : response;
    }
}
