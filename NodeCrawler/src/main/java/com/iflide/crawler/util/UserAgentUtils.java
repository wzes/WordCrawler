package com.iflide.crawler.util;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAgentUtils {
	private static HashMap<String, String> webUserAgentMap;
	private static ArrayList<String> webUserAgentList;
    static {   
		webUserAgentMap = new HashMap<>();
		webUserAgentList = new ArrayList<>();
        webUserAgentMap.put("Chrome 32.0.1667.0", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        for (String key : webUserAgentMap.keySet()) {
        	   webUserAgentList.add(webUserAgentMap.get(key));
        }
    }   


    public static String getOneRandom(){
    	return webUserAgentList.get((int) Math.round(Math.random()*(webUserAgentList.size() - 1)));
    }
}
