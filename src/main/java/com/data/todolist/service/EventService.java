package com.data.todolist.service;

import com.data.todolist.domain.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllByUserId(Long userId);
}
