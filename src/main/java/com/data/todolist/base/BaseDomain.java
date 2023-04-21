package com.data.todolist.base;

import java.io.Serializable;

public abstract class BaseDomain<ID extends Serializable> implements Serializable {
    private ID id;

    public BaseDomain() {
    }

    public ID getId() {
        return id;
    }
}
