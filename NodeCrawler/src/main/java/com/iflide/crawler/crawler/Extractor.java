package com.iflide.crawler.crawler;

import com.iflide.crawler.model.Url;
import com.iflide.crawler.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
@Component
public class Extractor {


    public List<Url> getAllLinks(String url, Document doc) {
        List<Url> urls = new ArrayList<>();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            urls.add(new Url(link.attr("abs:href")));
        }
        return urls;
    }

    public Url getAllText(String url, Document doc) {
        Elements ps = doc.getElementsByTag("p");
        StringBuilder sb = new StringBuilder();
        for (Element p : ps) {
            sb.append(p.text().trim());
        }
        String content = sb.toString();
        return new Url(url, content, content.length());
    }

    public List<Url> getAllLinks(String url, String html) {
        return getAllLinks(url, Jsoup.parse(html));
    }

    public Url getText(String url, String content) {
//        StringBuilder sb = new StringBuilder();
//        char[] contents = content.toCharArray();
//        for (char ch : contents) {
//            if (ch != '\n' && ch != '\t') {
//                sb.append(ch);
//            }
//        }
//        String res = sb.toString();
        return new Url(url, content);
    }
}
