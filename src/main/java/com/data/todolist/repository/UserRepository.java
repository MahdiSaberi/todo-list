package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.User;

public interface UserRepository extends BaseDomainRepository<User,Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}
