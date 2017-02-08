package com.sherlockshi.androidmvparchitecture.model.entity;

/**
 * eventbus测试类
 * Created by Francis on 2017-2-7.
 */
public class MessageEvent {
    private String title;
    private String content;
    private String author;

    public MessageEvent(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
