package com.data.todolist.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseDomain<ID>,ID extends Serializable> {
    T save(T t);
    T update(T t);
    List<T> findAll();
    void remove(ID id);
    T findById(ID id);
    void deleteById(ID id);
}
