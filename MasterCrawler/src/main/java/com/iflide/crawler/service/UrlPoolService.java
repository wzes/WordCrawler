package com.iflide.crawler.service;

import com.iflide.crawler.component.RedisConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private Map<Integer, Long> queueInfoMap;

    private boolean init = true;

    public UrlPoolService() {
    }

    /**
     * <p>Add url to queue</p>
     *
     * @param url
     */
    public void addUrl(String url) {
        // Get the queue with the least number of elements and push
        Long minCount = Long.MAX_VALUE;
        int desIndex = 0;
        for (int i = 0; i < RedisConsts.CRAWLER_QUEUES.length; i++) {
            if (queueInfoMap.containsKey(i)) {
                if (queueInfoMap.get(i) < minCount) {
                    desIndex = i;
                    minCount = queueInfoMap.get(i);
                }
            } else {
                desIndex = i;
                minCount = 0L;
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
        if (init) {
            queueInfoMap = new HashMap<>();
            for (int i = 0; i < RedisConsts.CRAWLER_QUEUES.length; i++) {
                Long size = redisTemplate.opsForList().size(RedisConsts.CRAWLER_QUEUES[i]);
                queueInfoMap.put(i, size);
            }
            init = false;
        }
        // Get the queue with a most number of elements and pop
        Long maximum = 0L;
        int maxIndex = 0;
        for (Map.Entry<Integer, Long> entry : queueInfoMap.entrySet()) {
            if (entry.getValue() > maximum) {
                maximum = entry.getValue();
                maxIndex = entry.getKey();
            }
        }
        if (maximum != 0) {
            queueInfoMap.put(maxIndex, maximum - 1);
            String url = pop(RedisConsts.CRAWLER_QUEUES[maxIndex]);
            logger.info("Pop: " + maximum + " " + maxIndex + " " + url);
            return url;
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
