package com.iflide.crawler.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class DispatcherImpl implements Dispatcher {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final RestTemplate mHttpClient = new RestTemplate();

    /**
     * <p>The threshold of waiting time for URL is null</p>
     *
     */
    private static final Long EXPIRES_MILLISECOND = 1000L;

    /**
     * <p>A threshold for performing tasks at the same time.</p>
     *
     */
    private static final Long DOWN_LOAD_THRESHOLD = 5L;

    /**
     * <p>Use locks to ensure that the number of tasks is within a certain range.</p>
     *
     */
    private ReentrantLock mGetLock = new ReentrantLock();
    private Condition mGetCondition = mGetLock.newCondition();
    private AtomicLong atomicLong = new AtomicLong();
    /**
     * <p>Get the service address of URL</p>
     *
     */
    @Value("${iflide.url.address}")
    private String url;

    @Autowired
    Downloader downloader;

    private volatile boolean flag = true;
    private int corePoolSize = Runtime.getRuntime().availableProcessors() == 0 ? 3 : Runtime.getRuntime().availableProcessors();
    private AtomicInteger atomicInteger = new AtomicInteger();
    private ThreadFactory mFactory = r -> new Thread("Crawler thread - " + atomicInteger.getAndIncrement());
    ExecutorService mDefaultPool = new ThreadPoolExecutor(corePoolSize * 2, corePoolSize * 4 + 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), mFactory);

    /**
     * <p>Get url from service</p>
     *
     * @return url string
     */
    private String getUrl() {
        String response = mHttpClient.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class).getBody();
        logger.info("Get url: " + response);
        return "null".equals(response) ? null : response;
    }

    /**
     * <p>Run the crawler</p>
     *
     */
    @Override
    public void run() {
        flag = true;
        logger.info("Run: ");
        // exit loop
        while (flag) {
            try {
                while (atomicLong.get() > DOWN_LOAD_THRESHOLD) {
                    Thread.sleep(5000);
                }
                // sync
                String url = getUrl();
                if (url != null) {
                    atomicLong.incrementAndGet();
                    // add task into threads pool
                    // async
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // async
                            downloader.handle(url);
                            // finish
                            atomicLong.decrementAndGet();
                        }
                    }).start();
                } else {
                    // wait some seconds
                    try {
                        Thread.sleep(EXPIRES_MILLISECOND);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                logger.info("Error: " + e.getMessage());
            }
        }
    }

    /**
     * <p>Stop the crawler</p>
     *
     */
    public void stop() {
        flag = false;
    }
}
