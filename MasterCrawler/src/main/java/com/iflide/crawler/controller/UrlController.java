package com.iflide.crawler.controller;

import com.iflide.crawler.service.UrlHelper;
import com.iflide.crawler.service.UrlPoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@RequestMapping("iflide/crawler")
@RestController
public class UrlController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private static final Long EXPIRES_MILLISECOND = 5000L;
    private static final int FOLLOWUP_TIME = 5;

    @Autowired
    UrlPoolService urlPoolService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/url")
    public String getUrl(@RequestHeader(name = "Host") String host) {
        String url = urlPoolService.popUrl();
        int followUp = 1;

        logger.info("Host: " + host);
        while (url != null) {
            String timestampKey = UrlHelper.getDomainName(url) + host;
            String timestamp = redisTemplate.opsForValue().get(timestampKey);
            logger.info("timestamp: " + timestamp);
            logger.info("result: " + "null".equals(timestamp));
            if (timestamp == null || timestamp.length() == 0 || Long.parseLong(timestamp) < System.currentTimeMillis()) {
                redisTemplate.opsForValue().set(timestampKey,
                        String.valueOf(System.currentTimeMillis() + EXPIRES_MILLISECOND));
                logger.info("Pop url: " + url);
                return url;
            } else if (followUp == FOLLOWUP_TIME) {
                try {
                    Thread.sleep(EXPIRES_MILLISECOND);
                    url = urlPoolService.popUrl();
                    followUp = 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                logger.info("followUp: " + followUp);
                followUp++;
                urlPoolService.addUrl(url);
                url = urlPoolService.popUrl();
            }
        }
        return "null";
    }
}
