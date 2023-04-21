package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

import java.util.List;

public class User extends BaseDomain<Long> {
    private String username;

    private List<Event> events;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", events=" + events +
                '}';
    }
}
