package com.iflide.crawler.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class DispatcherImpl implements Dispatcher {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final RestTemplate client = new RestTemplate();
    private static final Long EXPIRES_MILLISECOND = 1000L;
    @Value("${iflide.url.address}")
    private String url;

    @Autowired
    Downloader downloader;

    private volatile boolean flag = true;

    /**
     * <p>Get url from service</p>
     *
     * @return
     */
    private String getUrl() {
        String response = client.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class).getBody();
        logger.info("Get url: " + response);
        return "null".equals(response) ? null : response;
    }

    @Override
    public void run() {
        flag = true;
        logger.info("Run: ");
        while (flag) {
            // sync
            String url = getUrl();
            if (url != null) {
                // async
                downloader.handle(url);
            } else {
                // wait some seconds
                try {
                    Thread.sleep(EXPIRES_MILLISECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        flag = false;
    }
}
