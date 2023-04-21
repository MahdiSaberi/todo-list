package com.data.todolist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseDomainRepository<T extends BaseDomain<ID>,ID extends Serializable> extends JpaRepository<T,ID>,
        JpaSpecificationExecutor<T> {
}
