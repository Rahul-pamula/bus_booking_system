package com.example.busbooking.service.impl;

import com.example.busbooking.dao.BusDao;
import com.example.busbooking.model.Bus;
import com.example.busbooking.service.BusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BusServiceImpl implements BusService {

  @Autowired
  private BusDao busDao;

  @Override
  public List<Bus> search(String source, String destination, LocalDate travelDate) {
    return busDao.search(source, destination, travelDate);
  }

  @Override
  public Bus findById(Long id) { return busDao.findById(id); }

  @Override
  public Bus create(Bus bus) {
    busDao.save(bus);
    return bus;
  }

  @Override
  public void update(Bus bus) { busDao.update(bus); }
}


