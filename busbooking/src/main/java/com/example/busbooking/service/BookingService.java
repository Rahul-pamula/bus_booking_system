package com.example.busbooking.service;

import com.example.busbooking.model.Booking;
import java.util.List;

public interface BookingService {
  Booking createBooking(Long userId, Long busId, int seats);
  List<Booking> userBookings(Long userId);
}


