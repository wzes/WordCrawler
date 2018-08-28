package com.iflide.crawler.model;

import java.io.Serializable;

/**
 * @author Create by xuantang
 * @date on 8/27/18
 */
public class Url implements Serializable {
    private String name;
    private String content;
    private int wordCount;

    public Url() {
    }

    public Url(String name) {
        this.name = name;
    }

    public Url(String name, int wordCount) {
        this.name = name;
        this.wordCount = wordCount;
    }

    public Url(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Url(String name, String content, int wordCount) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
