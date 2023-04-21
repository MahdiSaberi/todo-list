package com.data.todolist.base;

import com.data.todolist.domain.User;
import org.yaml.snakeyaml.events.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public interface BaseService<T extends BaseDomain<ID>,ID extends Serializable> {
    Mono<T> save(T t);
    Mono<T> edit(T t);
    Flux<T> findAll();
    Mono<Void> remove(ID id);
}
