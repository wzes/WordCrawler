package com.iflide.crawler;

import com.iflide.crawler.crawler.DispatcherImpl;
import com.iflide.crawler.crawler.GlobalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class CrawlerStartupRunner implements CommandLineRunner {

    @Autowired
    DispatcherImpl dispatcher;

    @Override
    public void run(String... args) throws Exception {
        dispatcher.run();
    }
}
