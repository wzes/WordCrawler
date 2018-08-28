package com.iflide.crawler.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public class UrlHelperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUrlTypeTrue() {
        Assert.assertEquals("https://blog.csdn.net/lom9357bye/article/details",
                UrlHelper.getUrlType("https://blog.csdn.net/lom9357bye/article/details/77458797"));

        Assert.assertEquals("https://blog.csdn.net",
                UrlHelper.getUrlType("https://blog.csdn.net/lom9357bye"));

        Assert.assertEquals("https://blog.csdn.net",
                UrlHelper.getUrlType("https://blog.csdn.net"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUrlTypeException() {
        UrlHelper.getUrlType("");
    }
}