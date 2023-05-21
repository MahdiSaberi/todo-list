package com.data.todolist.service;

import com.data.todolist.domain.Box;

import java.util.List;

public interface BoxService {
    Box findByTopic(String topic);

    Box findByTopicAndId(String topic, Long id);

    Box findByIdAndUser_Id(Long boxId, Long userId);
    void deleteById(Long id);
    Box save(Box box);
    Box findByTopicAndUser_Id(String topic, Long userId);
    Box findById(Long id);
    Box update(Box box);
    List<Box> findAllByUserId(Long id);
}
