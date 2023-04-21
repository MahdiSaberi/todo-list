package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends BaseDomainRepository<User,Long> {
    Mono<User> findByUsername(String username);
    Mono<Boolean> existsByUsername(String username);
    Mono<User> findByUsernameAndPassword(String username, String password);

}
