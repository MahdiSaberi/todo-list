package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table
public class Box extends BaseDomain<Long> {
    @Column(unique = true)
    private String topic;
    @OneToMany(mappedBy = "box",cascade = CascadeType.ALL)
    private Set<Event> events;
    @ManyToOne
    @JsonIgnore
    private User user;

    public Box() {
    }

    public Box(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Box{" +
                "topic='" + topic + '\'' +
                ", events=" + events +
                ", user=" + user +
                '}';
    }
}
