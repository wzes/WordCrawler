package com.iflide.crawler.service;

import com.iflide.crawler.component.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@Service
public class CleanerService {
    @Autowired
    BloomFilter<String> bloomFilter;



    public void run () {

    }
}
