package com.data.todolist.service.impl;

import com.data.todolist.base.impl.BaseServiceImpl;
import com.data.todolist.domain.Box;
import com.data.todolist.repository.BoxRepository;
import com.data.todolist.service.BoxService;

public class BoxServiceImpl extends BaseServiceImpl<Box,Long> implements BoxService {
    BoxRepository repository;
}
