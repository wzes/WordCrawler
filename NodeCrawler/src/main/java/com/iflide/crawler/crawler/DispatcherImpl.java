package com.iflide.crawler.crawler;

import com.iflide.crawler.util.NetworkMonitor;
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
    private static final Long EXPIRES_MILLISECOND = 2000L;

    /**
     * <p>A threshold for performing tasks at the same time.</p>
     *
     */
    private static final Long DOWN_LOAD_THRESHOLD = 20L;

    /**
     * <p>Use locks to ensure that the number of tasks is within a certain range.</p>
     *
     */
    private AtomicLong atomicLong = new AtomicLong();
    /**
     * <p>Get the service address of URL</p>
     *
     */
    @Value("${iflide.url.address}")
    private String url;

    @Autowired
    Downloader downloader;

    @Autowired
    TaskManager taskManager;

    private NetworkMonitor networkMonitor = new NetworkMonitor();

    private volatile boolean flag = true;
    private int corePoolSize = Runtime.getRuntime().availableProcessors() == 0 ? 3 : Runtime.getRuntime().availableProcessors();
    private AtomicInteger atomicInteger = new AtomicInteger();
    private ThreadFactory mFactory = r -> new Thread(r,"Crawler thread - " + atomicInteger.getAndIncrement());
    ExecutorService mDefaultPool = new ThreadPoolExecutor(corePoolSize, corePoolSize * 4 + 1,
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
        new Thread(networkMonitor).start();
        // exit loop
        while (flag) {
            try {
                while (atomicLong.get() > DOWN_LOAD_THRESHOLD || !networkMonitor.isNetworkAvailable()) {
                    Thread.sleep(EXPIRES_MILLISECOND);
                }
                // sync
                final String url = getUrl();
                if (url != null) {
                    atomicLong.incrementAndGet();
                    // add task into threads pool
                    // async
                    downloader.handle(url, atomicLong);
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
