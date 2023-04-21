package com.data.todolist.base;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.io.Serializable;

public interface BaseDomainRepository<T extends BaseDomain<ID>,ID extends Serializable> extends ReactiveCrudRepository<T,ID> {
}
