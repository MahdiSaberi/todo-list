package com.data.todolist.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
@MappedSuperclass
public abstract class BaseDomain<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    public BaseDomain() {
    }

    public ID getId() {
        return id;
    }
}
