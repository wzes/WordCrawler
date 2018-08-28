package com.iflide.crawler.service;

import com.iflide.crawler.component.RedisConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class UrlPoolService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private Map<Integer, Integer> queueInfoMap = new HashMap<>();


    /**
     * <p>Add url to queue</p>
     *
     * @param url
     */
    public void addUrl(String url) {
        // Get the queue with the least number of elements and push
        int minCount = Integer.MAX_VALUE;
        int desIndex = 0;
        for (int i = 0; i < RedisConsts.CRAWLER_QUEUES.length; i++) {
            if (queueInfoMap.containsKey(i)) {
                if (queueInfoMap.get(i) < minCount) {
                    desIndex = i;
                    minCount = queueInfoMap.get(i);
                }
            } else {
                desIndex = i;
                minCount = 0;
                break;
            }
        }
        queueInfoMap.put(desIndex, minCount + 1);
        add(RedisConsts.CRAWLER_QUEUES[desIndex], url);
    }

    /**
     * <p>Get the queue with a most number of elements</p>
     *
     * @return url
     */
    public String popUrl() {
        // Get the queue with a most number of elements and pop
        int maximum = 0, maxIndex = 0;
        for (Map.Entry<Integer, Integer> entry : queueInfoMap.entrySet()) {
            if (entry.getValue() > maximum) {
                maximum = entry.getValue();
                maxIndex = entry.getKey();
            }
        }
        if (maximum != 0) {
            return pop(RedisConsts.CRAWLER_QUEUES[maxIndex]);
        }
        return null;
    }

    private void add(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    private String pop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }
}
