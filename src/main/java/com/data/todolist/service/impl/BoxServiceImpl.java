package com.data.todolist.service.impl;

import com.data.todolist.base.impl.BaseServiceImpl;
import com.data.todolist.domain.Box;
import com.data.todolist.repository.BoxRepository;
import com.data.todolist.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BoxServiceImpl extends BaseServiceImpl<Box, Long> implements BoxService {
    private final BoxRepository repository;

    @Autowired
    public BoxServiceImpl(BoxRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Box findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Box findByTopic(String topic) {
        return repository.findByTopic(topic);
    }

    @Override
    @Transactional
    public Box findByTopicAndId(String topic, Long id) {
        return repository.findByTopicAndId(topic, id);
    }

    @Override
    @Transactional
    public Box findByIdAndUser_Id(Long boxId, Long userId) {
        return repository.findByIdAndUser_Id(boxId, userId);
    }

    @Override
    @Transactional
    public Box findByTopicAndUser_Id(String topic, Long userId) {
        return repository.findByTopicAndUser_Id(topic, userId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
