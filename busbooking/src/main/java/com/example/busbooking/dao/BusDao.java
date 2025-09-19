package com.example.busbooking.dao;

import com.example.busbooking.model.Bus;
import java.time.LocalDate;
import java.util.List;

public interface BusDao {
  Bus findById(Long id);
  List<Bus> search(String source, String destination, LocalDate travelDate);
  Long save(Bus bus);
  void update(Bus bus);
}


