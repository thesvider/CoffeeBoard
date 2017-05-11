package com.coffee.web.controllers;

import com.coffee.domain.model.User;
import com.coffee.domain.repository.UserRepository;
import com.coffee.domain.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by olya on 12.05.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping(value = "/api/userdetais")
    public User userProfile(){
       return userRepository.findById(authenticationService.getUserId());
    }
}
