package com.example.busbooking.service.impl;

import com.example.busbooking.dao.UserDao;
import com.example.busbooking.model.User;
import com.example.busbooking.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public User register(String name, String email, String rawPassword) {
    if (userDao.findByEmail(email) != null) {
      throw new IllegalArgumentException("Email already registered");
    }
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    user.setPasswordHash(hash(rawPassword));
    user.setRole("USER");
    userDao.save(user);
    return user;
  }

  @Override
  public User authenticate(String email, String rawPassword) {
    User user = userDao.findByEmail(email);
    if (user == null) return null;
    String hash = hash(rawPassword);
    return hash.equals(user.getPasswordHash()) ? user : null;
  }

  @Override
  public User findById(Long id) {
    return userDao.findById(id);
  }

  private String hash(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) sb.append(String.format("%02x", b));
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}


