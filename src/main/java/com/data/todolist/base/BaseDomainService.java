package com.data.todolist.base;

import java.io.Serializable;

public interface BaseDomainService<E extends BaseDomain<ID> ,ID extends Serializable> {
    E save(E t);
    void deleteById(ID id);
    E findById(ID id);

}
