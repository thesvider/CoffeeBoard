package com.coffee.domain.service.Impl;



import com.coffee.domain.model.User;
import com.coffee.domain.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void authenticate(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(token));
    }

    @Override
    public void logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
    }

    @Override
    public void authenticate(String email, String password) {
        authenticate(new User(email, password));
    }

    @Override
    public String getUserEmail() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
    }

    @Override
    public Long getUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
