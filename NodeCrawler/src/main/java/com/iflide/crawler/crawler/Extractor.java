package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;
import com.iflide.crawler.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class Extractor {


    /**
     * <p>Get all links from html document</p>
     *
     * @param url
     * @param doc
     * @return url List
     */
    public List<Url> getAllLinks(String url, Document doc) {
        List<Url> urls = new ArrayList<>();
        doc.setBaseUri(url);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            urls.add(new Url(link.attr("abs:href")));
        }
        return urls;
    }

    List<Url> getAllLinks(String url, String html) {
        return getAllLinks(url, Jsoup.parse(html));
    }

    /**
     * <p>Get content</p>
     *
     * @param url
     * @param html
     * @return
     */
    Url getText(String url, String html) {
        return getText(url, Jsoup.parse(html));
    }

    public Url getText(String url, Document document) {
        return new Url(url, document.text());
    }
}
