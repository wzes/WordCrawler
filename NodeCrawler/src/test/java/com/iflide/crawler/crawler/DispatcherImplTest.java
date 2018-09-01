package com.iflide.crawler.crawler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DispatcherImplTest {

    @Autowired
    DispatcherImpl dispatcher;

    @Autowired
    Downloader downloader;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() {
        downloader.handle("http://www.xinhuanet.com/politics/xxjxs/#index_1", new AtomicLong());
    }

    @Test
    public void stop() {
    }
}