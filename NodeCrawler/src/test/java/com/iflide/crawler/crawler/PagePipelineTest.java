package com.iflide.crawler.crawler;

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
 * @date on 8/28/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PagePipelineTest {

    @Autowired
    PagePipeline pagePipeline;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveUrl() {
        pagePipeline.save("http://www.baidu.com", "百度一下，就知道");
    }

    @Test
    public void saveUrls() {
        pagePipeline.save(Arrays.asList(new Url("http://www.baidu.com")));
    }
}