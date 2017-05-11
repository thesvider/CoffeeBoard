package com.coffee.domain.service.Impl;

import com.coffee.domain.model.Role;
import com.coffee.domain.model.User;
import com.coffee.domain.repository.UserRepository;
import com.coffee.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User saveNewUser(String email, String password) {
        User user  = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
