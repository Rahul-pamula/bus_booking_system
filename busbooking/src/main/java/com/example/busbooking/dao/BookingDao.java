package com.example.busbooking.dao;

import com.example.busbooking.model.Booking;
import java.util.List;

public interface BookingDao {
  Booking findById(Long id);
  List<Booking> findByUserId(Long userId);
  Long save(Booking booking);
}


