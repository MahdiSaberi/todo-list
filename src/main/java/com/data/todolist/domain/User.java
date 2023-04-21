package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "user_tbl")
public class User extends BaseDomain<Long> {
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
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
