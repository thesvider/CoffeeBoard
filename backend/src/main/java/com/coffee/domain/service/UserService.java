package com.coffee.domain.service;

import com.coffee.domain.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User findUserById(Long userId);

    User saveNewUser(String email, String password);

}
