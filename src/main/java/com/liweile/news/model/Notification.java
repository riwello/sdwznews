package com.liweile.news.model;

import java.util.Date;

public class Notification {
    private String username;
    private Date time;
    private String content;

    public Notification(String username, Date time, String content) {
        this.username = username;
        this.time = time;
        this.content = content;
    }

    public Notification() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
