package com.iflide.crawler.model;

import java.io.Serializable;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
public class Url implements Serializable {
    private String name;
    private int wordCount;

    public Url(String name, int wordCount) {
        this.name = name;
        this.wordCount = wordCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
