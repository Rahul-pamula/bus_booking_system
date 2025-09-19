package com.example.busbooking.dao.impl;

import com.example.busbooking.dao.BookingDao;
import com.example.busbooking.model.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() { return sessionFactory.getCurrentSession(); }

  @Override
  public Booking findById(Long id) {
    return getCurrentSession().get(Booking.class, id);
  }

  @Override
  public List<Booking> findByUserId(Long userId) {
    return getCurrentSession()
        .createQuery("from Booking b where b.user.id = :uid order by b.bookedAt desc", Booking.class)
        .setParameter("uid", userId)
        .list();
  }

  @Override
  public Long save(Booking booking) {
    return (Long) getCurrentSession().save(booking);
  }
}


