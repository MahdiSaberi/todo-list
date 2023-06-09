package com.data.todolist.service.impl;

import com.data.todolist.domain.User;
import com.data.todolist.repository.UserRepository;
import com.data.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(String username, String password) {
        if (repository.findByUsername(username) == null) {
            return repository.save(new User(username, password));
        } else {
            return null;
        }
    }

    @Transactional
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public User findByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void remove(String username) {
        User user = repository.findByUsername(username);
        repository.delete(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }
}
