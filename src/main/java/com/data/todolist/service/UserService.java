package com.data.todolist.service;

import com.data.todolist.domain.User;

import java.util.List;

public interface UserService {
    User save(String username,String password);
    User findByUsernameAndPassword(String username,String password);
    User findById(Long id);
    User update(User user);
    List<User> findAll();
    void remove(String username);
}
