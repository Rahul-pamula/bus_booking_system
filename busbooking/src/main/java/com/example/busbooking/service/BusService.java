package com.example.busbooking.service;

import com.example.busbooking.model.Bus;
import java.time.LocalDate;
import java.util.List;

public interface BusService {
  List<Bus> search(String source, String destination, LocalDate travelDate);
  Bus findById(Long id);
  Bus create(Bus bus);
  void update(Bus bus);
}


