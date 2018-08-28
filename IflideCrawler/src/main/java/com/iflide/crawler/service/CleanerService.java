package com.iflide.crawler.service;

import com.iflide.crawler.component.BloomFilter;
import com.iflide.crawler.component.RedisConsts;
import com.iflide.crawler.component.RedisService;
import com.iflide.crawler.model.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Service
public class CleanerService {
    @Autowired
    BloomFilter<String> bloomFilter;

    @Autowired
    RedisService redisService;

    private HashMap<String, Integer> urlTypeMap = new HashMap<>();
    private HashMap<String, List<Url>> urlInfoMap = new HashMap<>();
    private static final int FILTER_URL_NUM_THRESHOLD = 10;
    private static final int FILTER_WORD_COUNT_THRESHOLD = 100;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void handle (List<Url> urls) {
        for (Url url : urls) {
            String urlType = UrlHelper.getUrlType(url.getName());
            if (bloomFilter.contains(RedisConsts.FILTER_BLOOMFILTER, urlType)) {
                logger.info("Filter url with url type: " + url.getName());
                continue;
            }
            // not exist in crawler queue
            // or exist go queue
            if (!bloomFilter.contains(RedisConsts.CRAWLER_BLOOMFILTER, url.getName()) ||
                    bloomFilter.contains(RedisConsts.GO_BLOOMFILTER, urlType)) {
                redisService.addUrl(url.getName());
                logger.info("Add url: " + url.getName());
            } else {
                // calculate url type and filter
                if (urlTypeMap.containsKey(urlType)) {
                    Integer num = urlTypeMap.get(urlType);
                    if (num > FILTER_URL_NUM_THRESHOLD) {
                        boolean filter = false;
                        for (Url urlTmp : urlInfoMap.get(urlType)) {
                            if (urlTmp.getWordCount() < FILTER_WORD_COUNT_THRESHOLD) {
                                filter = true;
                                break;
                            }
                        }
                        if (filter) {
                            bloomFilter.add(RedisConsts.FILTER_BLOOMFILTER, urlType);
                            logger.info("Add filter url with url type: " + urlType);
                        } else {
                            bloomFilter.add(RedisConsts.GO_BLOOMFILTER, urlType);
                            logger.info("Add go url with url type: " + urlType);
                        }
                    } else {
                        urlTypeMap.put(urlType, num + 1);
                        urlInfoMap.get(urlType).add(url);
                        logger.info("Handle url type: " + urlType);
                    }
                } else {
                    urlTypeMap.put(urlType, 1);
                    urlInfoMap.put(urlType, Arrays.asList(url));
                    logger.info("Handle url type with new url type: " + urlType);
                }
            }
        }
    }
}
