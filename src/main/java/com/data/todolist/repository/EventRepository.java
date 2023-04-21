package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.Event;

import java.util.List;

public interface EventRepository extends BaseDomainRepository<Event,Long> {
    List<Event> findAllByUserId(Long id);
}
