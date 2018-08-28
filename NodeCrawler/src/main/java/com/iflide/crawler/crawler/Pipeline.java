package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public abstract class Pipeline {
    /**
     * <p>Save the url</p>
     *
     * @see Url
     * @param urls a list of urls
     */
    protected abstract void save(List<Url> urls);

    /**
     * <p>Save the url and content</p>
     *
     * @param url url
     * @param content page content
     */
    protected abstract void save(String url, String content);
}
