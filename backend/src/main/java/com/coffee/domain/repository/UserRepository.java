package com.coffee.domain.repository;

import com.coffee.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findById(Long id);
}
