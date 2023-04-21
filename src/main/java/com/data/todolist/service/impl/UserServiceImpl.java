package com.data.todolist.service.impl;

import com.data.todolist.domain.User;
import com.data.todolist.repository.UserRepository;
import com.data.todolist.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Random;

public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Override
    public Mono<User> save(String username) {
        if (Boolean.FALSE.equals(repository.existsByUsername(username).block()))
            return repository.save(new User(username));
        else {
            int number = new Random().nextInt(100) + 1;
            return save(username + number);
        }
    }

    @Override
    public Mono<User> edit(User user) {
        return repository.findById(user.getId())
                .flatMap(u -> {
                    u.setUsername(u.getUsername());
                    return repository.save(user);
                });

    }

    @Override
    public Flux<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> remove(String username) {
        return repository.findByUsername(username)
                .flatMap(user -> {
                    return repository.delete(user);
                });
    }
}
