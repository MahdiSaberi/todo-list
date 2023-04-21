package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

import java.util.List;

public class User extends BaseDomain<Long> {
    private String username;
    private String password;
    private List<Event> events;

    public User(String username,String password) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", events=" + events +
                '}';
    }
}
