package com.example.busbooking.service;

import com.example.busbooking.model.User;

public interface UserService {
  User register(String name, String email, String rawPassword);
  User authenticate(String email, String rawPassword);
  User findById(Long id);
}


