package com.iflide.crawler.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Create by xuantang
 * @date on 9/5/18
 */
@Component
public class CookieManager {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public String getCookie(String host) {
        String key = "cookie_" + host;
        Long size = redisTemplate.opsForList().size(key);
        if (size == 0) {
            return null;
        }
        int index = new Random(System.currentTimeMillis()).nextInt(Math.toIntExact(size));
        return redisTemplate.opsForList().index(key, index);
    }
}
