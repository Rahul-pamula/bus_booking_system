package com.example.busbooking.web;

import com.example.busbooking.model.Booking;
import com.example.busbooking.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

  @Autowired private BookingService bookingService;

  @PostMapping("/create")
  public String create(Long busId, int seats, HttpSession session, Model model) {
    Long userId = (Long) session.getAttribute("userId");
    if (userId == null) {
      return "redirect:/auth/login";
    }
    try {
      bookingService.createBooking(userId, busId, seats);
      model.addAttribute("msg", "Booking successful");
    } catch (IllegalArgumentException ex) {
      model.addAttribute("error", ex.getMessage());
    }
    return "redirect:/bookings/my";
  }

  @GetMapping("/my")
  public String myBookings(HttpSession session, Model model) {
    Long userId = (Long) session.getAttribute("userId");
    if (userId == null) return "redirect:/auth/login";
    List<Booking> list = bookingService.userBookings(userId);
    model.addAttribute("bookings", list);
    return "booking/list";
  }
}


