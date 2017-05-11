package com.coffee.web.controllers;

import com.coffee.domain.model.User;
import com.coffee.domain.service.AuthenticationService;
import com.coffee.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by olya on 11.05.2017.
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/login")
    public void login(@RequestParam String email, @RequestParam String password){
       authenticationService.authenticate(email, password);
    }

    @PostMapping(value = "/api/login")
    public void loginAngular(@RequestParam String email, @RequestParam String password){
        int a = 0;
    }

    @GetMapping(value = "/api/signup")
    public User signUp(@RequestParam String email, @RequestParam String password){
        return userService.saveNewUser(email, password);
    }

    @PostMapping(value = "/api/signup")
    public void signUpAngular(@RequestBody User user){
        int a = 0;
    }
}
