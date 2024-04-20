package com.videomeetingapp.service;

import com.videomeetingapp.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);

    User getUserById(Long userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
