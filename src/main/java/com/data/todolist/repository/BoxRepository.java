package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.Box;
import com.data.todolist.domain.Event;

public interface BoxRepository extends BaseDomainRepository<Box,Long> {
    Box findByTopic(String topic);
    Box findByTopicAndId(String topic, Long id);
    Box findByIdAndUser_Id(Long boxId, Long userId);
    Box findByTopicAndUser_Id(String topic, Long userId);
    void deleteById(Long id);
}
