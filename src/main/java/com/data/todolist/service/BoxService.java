package com.data.todolist.service;

import com.data.todolist.domain.Box;

public interface BoxService {
    Box findById(Long id);
    Box findByTopic(String topic);
    Box findByTopicAndId(String topic, Long id);
    Box findByIdAndUser_Id(Long boxId, Long userId);
    Box findByTopicAndUser_Id(String topic, Long userId);
    void deleteById(Long id);
}
