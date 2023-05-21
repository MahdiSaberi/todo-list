package com.data.todolist.service;

import com.data.todolist.base.BaseDomainService;
import com.data.todolist.domain.Event;

import java.util.List;

public interface EventService extends BaseDomainService<Event, Long> {
    List<Event> findAllByUserId(Long userId);

}
