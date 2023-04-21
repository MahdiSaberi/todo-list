package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

public class Event extends BaseDomain<Long> {
    private String title;
    private String content;

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

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
