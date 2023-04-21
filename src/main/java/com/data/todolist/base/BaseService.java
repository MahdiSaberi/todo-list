package com.data.todolist.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseDomain<ID>,ID extends Serializable> {
    T save(T t);
    T edit(T t);
    List<T> findAll();
    void remove(ID id);
}
