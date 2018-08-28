package com.iflide.crawler.util;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAgentUtils {
	private static HashMap<String, String> webUserAgentMap;
	private static ArrayList<String> webUserAgentList;
    static {   
		webUserAgentMap = new HashMap<>();
		webUserAgentList = new ArrayList<>();
        webUserAgentMap.put("safari 5.1 – MAC", "");
        webUserAgentMap.put("safari 5.1 – Windows", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");
        webUserAgentMap.put("Firefox 38esr", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
        webUserAgentMap.put("IE 11", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; InfoPath.3; rv:11.0) like Gecko");
        webUserAgentMap.put("IE 9.0", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");
        webUserAgentMap.put("IE 8.0", "User-Agent:Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
        webUserAgentMap.put("Firefox 4.0.1 – MAC", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        webUserAgentMap.put("Firefox 4.0.1 – Windows", "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        webUserAgentMap.put("Opera 11.11 – MAC", "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11");
        webUserAgentMap.put("Opera 11.11 – Windows","Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11");
        webUserAgentMap.put("Chrome 17.0 – MAC", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
        webUserAgentMap.put("Chrome 32.0.1667.0", "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36");
        webUserAgentMap.put("傲游（Maxthon）", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)");
        webUserAgentMap.put("世界之窗（The World） 2.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
        webUserAgentMap.put("世界之窗（The World） 3.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; The World)");
        webUserAgentMap.put("搜狗浏览器 1.x", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)");
        webUserAgentMap.put("360浏览器","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)");
        for (String key : webUserAgentMap.keySet()) {
        	   webUserAgentList.add(webUserAgentMap.get(key));
        }
    }   


    public static String getOneRandom(){
    	return webUserAgentList.get((int) Math.round(Math.random()*(webUserAgentList.size() - 1)));
    }
}
