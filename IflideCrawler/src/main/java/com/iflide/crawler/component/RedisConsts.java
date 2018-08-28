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
    public static final String[] CRAWLER_QUEUES = new String[]{ "CRAWLER_QUEUE_1",
                                                                "CRAWLER_QUEUE_2",
                                                                "CRAWLER_QUEUE_3",
                                                                "CRAWLER_QUEUE_4",
                                                                "CRAWLER_QUEUE_5",
                                                                "CRAWLER_QUEUE_6",
                                                                "CRAWLER_QUEUE_7",
                                                                "CRAWLER_QUEUE_8",
                                                                "CRAWLER_QUEUE_9" };

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
