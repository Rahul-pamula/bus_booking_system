package com.example.busbooking.dao.impl;

import com.example.busbooking.dao.BusDao;
import com.example.busbooking.model.Bus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BusDaoImpl implements BusDao {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() { return sessionFactory.getCurrentSession(); }

  @Override
  public Bus findById(Long id) {
    return getCurrentSession().get(Bus.class, id);
  }

  @Override
  public List<Bus> search(String source, String destination, LocalDate travelDate) {
    LocalDateTime start = travelDate.atStartOfDay();
    LocalDateTime end = travelDate.atTime(23, 59, 59);
    return getCurrentSession()
        .createQuery("from Bus b where b.source = :src and b.destination = :dst and b.departureTime between :s and :e", Bus.class)
        .setParameter("src", source)
        .setParameter("dst", destination)
        .setParameter("s", start)
        .setParameter("e", end)
        .list();
  }

  @Override
  public Long save(Bus bus) {
    return (Long) getCurrentSession().save(bus);
  }

  @Override
  public void update(Bus bus) {
    getCurrentSession().update(bus);
  }
}


