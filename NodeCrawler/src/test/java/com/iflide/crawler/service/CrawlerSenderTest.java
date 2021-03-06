package com.iflide.crawler.service;

import com.iflide.crawler.model.Url;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerSenderTest {

    @Autowired
    CrawlerSender crawlerSender;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void send() {
        crawlerSender.send(Arrays.asList(new Url("http://www.baidu.com", 1221)));
    }
}