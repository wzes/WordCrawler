package com.iflide.crawler.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext transdocApplication;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.transdocApplication).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUrl() {
        try {
            MvcResult mvcResult = mockMvc
                    .perform(get("/iflide/crawler/url"))
                    .andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}