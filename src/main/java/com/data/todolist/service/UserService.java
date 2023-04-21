package com.data.todolist.service;

import com.data.todolist.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> save(String username);
    Mono<User> edit(User user);
    Flux<User> findAll();
    Mono<Void> remove(String username);
}
