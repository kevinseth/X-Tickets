package com.x_ticket.Service.impl;

import com.x_ticket.Model.User;
import com.x_ticket.Repository.UserRepository;
import com.x_ticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        // Update user details
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
