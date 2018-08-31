package com.iflide.crawler.crawler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author Create by xuantang
 * @date on 8/31/18
 */
public class Task implements Callable<String> {
    private Runnable runnable;
    private String url;


    Task(Runnable runnable, String url) {
        this.runnable = runnable;
        this.url = url;
    }

    @Override
    public String call() {
        runnable.run();
        return url;
    }
}
