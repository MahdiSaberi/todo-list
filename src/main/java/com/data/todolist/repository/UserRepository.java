package com.data.todolist.repository;

import com.data.todolist.base.BaseDomainRepository;
import com.data.todolist.domain.User;
import reactor.core.publisher.Flux;

public interface UserRepository extends BaseDomainRepository<User,Long> {

}
