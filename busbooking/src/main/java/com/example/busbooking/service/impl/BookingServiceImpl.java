package com.example.busbooking.service.impl;

import com.example.busbooking.dao.BookingDao;
import com.example.busbooking.dao.BusDao;
import com.example.busbooking.dao.UserDao;
import com.example.busbooking.model.Booking;
import com.example.busbooking.model.Bus;
import com.example.busbooking.model.User;
import com.example.busbooking.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

  @Autowired private BookingDao bookingDao;
  @Autowired private BusDao busDao;
  @Autowired private UserDao userDao;

  @Override
  public Booking createBooking(Long userId, Long busId, int seats) {
    User user = userDao.findById(userId);
    Bus bus = busDao.findById(busId);
    if (user == null || bus == null) {
      throw new IllegalArgumentException("Invalid user or bus");
    }
    if (seats <= 0 || seats > bus.getAvailableSeats()) {
      throw new IllegalArgumentException("Insufficient seats available");
    }
    bus.setAvailableSeats(bus.getAvailableSeats() - seats);
    busDao.update(bus);

    Booking booking = new Booking();
    booking.setUser(user);
    booking.setBus(bus);
    booking.setSeats(seats);
    bookingDao.save(booking);
    return booking;
  }

  @Override
  public List<Booking> userBookings(Long userId) {
    return bookingDao.findByUserId(userId);
  }
}


