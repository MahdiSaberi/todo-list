package com.data.todolist.service.impl;

import com.data.todolist.base.impl.BaseServiceImpl;
import com.data.todolist.domain.Event;
import com.data.todolist.repository.EventRepository;
import com.data.todolist.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EventServiceImpl extends BaseServiceImpl<Event, Long, EventRepository> implements EventService {

    public EventServiceImpl(EventRepository repository) {
        super(repository);
    }

    @Override
    public List<Event> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

//    @Override
//    public void deleteById(Long id) {
//        repository.deleteById(id);
//    }

//    @Override
//    @Transactional
//    public Event findById(Long id) {
//        return repository.findById(id).get();
//    }
}
