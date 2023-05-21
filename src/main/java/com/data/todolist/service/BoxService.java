package com.data.todolist.service;

import com.data.todolist.base.BaseDomainService;
import com.data.todolist.domain.Box;

public interface BoxService extends BaseDomainService<Box, Long> {
    Box findByTopic(String topic);
    Box findByTopicAndId(String topic, Long id);
    Box findByIdAndUser_Id(Long boxId, Long userId);
    Box findByTopicAndUser_Id(String topic, Long userId);
    Box update(Box box);}
