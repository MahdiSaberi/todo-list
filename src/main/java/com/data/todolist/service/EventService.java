package com.data.todolist.service;

import com.data.todolist.domain.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventService {
    Flux<Event> findAllByUserId(Long userId);
}
