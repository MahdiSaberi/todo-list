package com.data.todolist.base.impl;

import com.data.todolist.base.BaseDomain;
import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDomain<ID>, ID extends Serializable> implements BaseService<T, ID> {

    BaseDomainRepository repository;

    @Override
    @Transactional
    public T save(T t) {
        return (T) repository.save(t);
    }

    @Override
    @Transactional
    public T update(T t) {
        Object o = repository.findById(t.getId()).get();
        return (T) repository.save(o);
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
       return (T) repository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
         repository.deleteById(id);
    }
}
