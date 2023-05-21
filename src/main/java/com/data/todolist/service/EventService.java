package com.data.todolist.service;

import com.data.todolist.domain.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllByUserId(Long userId);
    Event findById(Long id);
    void deleteById(Long id);
    Event update(Event event);
    Event save(Event event);
}
