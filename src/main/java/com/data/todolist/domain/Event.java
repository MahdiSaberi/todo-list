package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Event extends BaseDomain<Long> {
    @Column
    private String title;
    @Column
    private String content;
    @ManyToOne
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
