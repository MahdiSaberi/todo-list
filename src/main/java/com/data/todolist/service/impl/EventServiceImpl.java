package com.data.todolist.service.impl;

import com.data.todolist.base.impl.BaseServiceImpl;
import com.data.todolist.domain.Event;
import com.data.todolist.repository.EventRepository;
import com.data.todolist.service.EventService;

import java.util.List;

public class EventServiceImpl extends BaseServiceImpl<Event, Long> implements EventService {
    EventRepository repository;

    @Override
    public List<Event> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

}
