package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

public class User extends BaseDomain<Long> {
    private String username;

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
}
