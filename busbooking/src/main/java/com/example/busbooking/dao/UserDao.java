package com.example.busbooking.dao;

import com.example.busbooking.model.User;

public interface UserDao {
  User findByEmail(String email);
  User findById(Long id);
  Long save(User user);
}


