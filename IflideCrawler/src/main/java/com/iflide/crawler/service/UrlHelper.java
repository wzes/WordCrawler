package com.iflide.crawler.service;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public class UrlHelper {

    private static final int LOW_INDEX = 8;

    public static String getUrlType(String url) {
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        int index = url.lastIndexOf('/');
        // http:// or https://
        if (index < LOW_INDEX) {
            return url;
        }
        return url.substring(0, index);
    }
}
