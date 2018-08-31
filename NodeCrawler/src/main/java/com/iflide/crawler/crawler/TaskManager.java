package com.iflide.crawler.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @author Create by xuantang
 * @date on 8/31/18
 */
@Component
public class TaskManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private static final long CRAWLER_TIMEOUT = 7000L;

    private ExecutorService service = new ThreadPoolExecutor(0, 60,
            60, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Crawler cleaner");
        }
    });


    void addTask(Future<?> future) {
        service.execute(() -> {
            try {
                Object o = future.get(CRAWLER_TIMEOUT, TimeUnit.SECONDS);
                logger.info("Success crawl: " + o.toString());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
            }
        });
    }
}
