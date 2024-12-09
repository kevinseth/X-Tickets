package com.x_ticket.Service;

import com.x_ticket.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User createUser(User user);
    User updateUser(String id, User userDetails);
    void deleteUser(String id);
}
