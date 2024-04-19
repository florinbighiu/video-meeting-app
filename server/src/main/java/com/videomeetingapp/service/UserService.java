package com.videomeetingapp.service;

import com.videomeetingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);

    Optional<User> getUserById(Long userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
