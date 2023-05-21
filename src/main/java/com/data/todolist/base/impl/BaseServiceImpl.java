package com.data.todolist.base.impl;

import com.data.todolist.base.BaseDomain;
import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDomain<ID>,
        ID extends Serializable,
        R extends BaseDomainRepository<T,ID>> implements BaseService<T, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    @Transactional
    public T update(T t) {
        T o = repository.findById(t.getId()).get();
        return repository.save(o);
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void remove(ID id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public T findById(ID id){
       return repository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
         repository.deleteById(id);
    }
}
