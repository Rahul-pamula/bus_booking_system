package com.example.busbooking.dao.impl;

import com.example.busbooking.dao.UserDao;
import com.example.busbooking.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public User findByEmail(String email) {
    return getCurrentSession()
        .createQuery("from User u where u.email = :email", User.class)
        .setParameter("email", email)
        .uniqueResult();
  }

  @Override
  public User findById(Long id) {
    return getCurrentSession().get(User.class, id);
  }

  @Override
  public Long save(User user) {
    return (Long) getCurrentSession().save(user);
  }
}


