package com.iflide.crawler.component;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
public class RedisConsts {

    /**
     * <p>queue names</p>
     *
     */
    public static final String[] CRAWLER_QUEUES = new String[100];

    static {
        for (int i = 0; i < CRAWLER_QUEUES.length; i++) {
            CRAWLER_QUEUES[i] = "CRAWLER_QUEUE_" + i;
        }
    }

    /**
     * <p>Url filter key</p>
     *
     */
    public static final String CRAWLER_BLOOMFILTER = "CRAWLER";

    /**
     * <p>Go key</p>
     *
     */
    public static final String GO_BLOOMFILTER = "GO_CRAWLER";

    /**
     * <p>Filter key</p>
     *
     */
    public static final String FILTER_BLOOMFILTER = "FILTER_CRAWLER";

}
