package com.videomeetingapp.repository;

import com.videomeetingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsernameContaining(String usernamePattern);

    User findByUsername(String username);
}
