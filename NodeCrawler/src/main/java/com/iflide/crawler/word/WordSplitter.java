package com.iflide.crawler.word;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public class WordSplitter {

    public Map<String, Integer> handle(String content) {
        HashMap<String, Integer> wordMap = new HashMap<>(1 << 10);
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> process = segmenter.process(content, JiebaSegmenter.SegMode.SEARCH);
        for (SegToken token : process) {
            if (wordMap.containsKey(token.word)) {
                wordMap.put(token.word, wordMap.get(token.word) + 1);
            } else {
                wordMap.put(token.word, 1);
            }
        }
        return wordMap;
    }
}
