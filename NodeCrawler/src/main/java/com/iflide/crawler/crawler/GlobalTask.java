package com.iflide.crawler.crawler;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public enum  GlobalTask {
    INSTANCE;

    private int corePoolSize = Runtime.getRuntime().availableProcessors();
    private AtomicInteger atomicInteger = new AtomicInteger();
    private ThreadFactory mFactory = r -> new Thread("Crawler thread - " + atomicInteger.getAndIncrement());
    public ExecutorService mDefaultPool = new ThreadPoolExecutor(corePoolSize * 2, corePoolSize * 4 + 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), mFactory);
}
