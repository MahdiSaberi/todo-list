package com.data.todolist.base.impl;

import com.data.todolist.base.BaseDomain;
import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.base.BaseService;
import com.data.todolist.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.Random;

public class BaseServiceImpl<T extends BaseDomain<ID>,ID extends Serializable> implements BaseService<T,ID> {

    BaseDomainRepository repository;

    @Override
    public Mono<T> save(T t) {
        return repository.save(t);
    }

    @Override
    public Mono<T> edit(T t) {
        return repository.findById(t.getId())
                .flatMap(e -> {
                    return repository.save(t);
                });
    }

    @Override
    public Flux<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> remove(ID id) {
        return repository.deleteById(id);
    }
}
