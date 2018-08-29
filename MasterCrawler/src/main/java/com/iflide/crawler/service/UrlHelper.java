package com.iflide.crawler.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public class UrlHelper {
    private final static Set<String> SUFFIX_SET = new HashSet<>(
            Arrays.asList(("com|org|net|gov|edu|co|tv|mobi|info|asia|xxx|onion|" +
                    "cn|com.cn|edu.cn|gov.cn|net.cn|org.cn|jp|kr|tw|com.hk|hk|com.hk|org.hk|se|com.se|org.se")
                    .split("\\|")));

    private static Pattern IP_PATTERN = Pattern
            .compile("(\\d{1,3}\\.){3}(\\d{1,3})");
    private static final int LOW_INDEX = 8;

    public static String getUrlType(String url) {
        if (url == null || url.length() == 0) {
            return null;
        }
        int index = url.lastIndexOf('/');
        // http:// or https://
        if (index < LOW_INDEX) {
            return url;
        }
        return url.substring(0, index);
    }

    /**
     * <p>Get domain name</p>
     *
     * @param url String
     * @return String url domain name
     * @throws MalformedURLException
     */
    public static String getDomainName(String url) {
        try {
            return getDomainName(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>Get domain name</p>
     *
     * @see URL
     * @param url {@link URL}
     * @return String url domain name
     */
    private static String getDomainName(URL url) {
        String host = url.getHost();
        if (host.endsWith(".")) {
            host = host.substring(0, host.length() - 1);
        }
        if (IP_PATTERN.matcher(host).matches()) {
            return host;
        }
        int index = 0;
        String candidate = host;
        for (; index >= 0;) {
            index = candidate.indexOf('.');
            String subCandidate = candidate.substring(index + 1);
            if (SUFFIX_SET.contains(subCandidate)) {
                return candidate;
            }
            candidate = subCandidate;
        }
        return candidate;
    }
}
