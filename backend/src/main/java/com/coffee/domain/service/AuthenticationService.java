package com.coffee.domain.service;


import com.coffee.domain.model.User;

public interface AuthenticationService {
    void authenticate(String email, String password);
    void authenticate(User user);
    void logout();
    String getUserEmail();
    Long getUserId();
}
