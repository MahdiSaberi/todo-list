package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.Event;
import com.data.todolist.domain.User;

public interface EventRepository extends BaseDomainRepository<Event,Long> {
}
