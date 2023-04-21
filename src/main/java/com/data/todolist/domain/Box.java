package com.data.todolist.domain;

import com.data.todolist.base.BaseDomain;

import java.util.Set;

public class Box extends BaseDomain<Long> {
    private String topic;
    private Set<Event> events;

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

    @Override
    public String toString() {
        return "Box{" +
                "topic='" + topic + '\'' +
                ", events=" + events +
                '}';
    }
}
