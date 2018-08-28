package com.iflide.crawler.component;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BloomFilterTest {

    @Autowired
    BloomFilter<String> bloomFilter;

    @Before
    public void setUp() throws Exception {
        bloomFilter.add(RedisConsts.CRAWLER_BLOOMFILTER, "https://www.jianshu.com/p/9f6bab6bfdb5");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        bloomFilter.add(RedisConsts.CRAWLER_BLOOMFILTER, "https://www.jianshu.com/p/9f6bab6bfdb5");
    }

    @Test
    public void addAll() {
    }

    @Test
    public void contains() {
        Assert.assertTrue(bloomFilter.contains(RedisConsts.CRAWLER_BLOOMFILTER, "https://www.jianshu.com/p/9f6bab6bfdb5"));

        Assert.assertFalse(bloomFilter.contains(RedisConsts.CRAWLER_BLOOMFILTER, "https://www.jianshu.com/p"));
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void getSizeOfBloomFilter() {
    }

    @Test
    public void getExpectedNumberOfElements() {
    }
}