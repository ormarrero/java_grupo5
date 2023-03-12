package com.example.service;

import com.example.entities.UserEntity;

public interface UserService {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserEntity save(UserEntity user);
}