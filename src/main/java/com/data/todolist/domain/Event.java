package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

public class Event extends BaseDomain<Long> {
    private String title;
    private String content;
    private User user;

    public Event() {
    }

    public Event(String title, String content) {
        this.title = title;
        this.content = content;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
