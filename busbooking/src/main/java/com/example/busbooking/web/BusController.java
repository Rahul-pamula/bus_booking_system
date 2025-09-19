package com.example.busbooking.web;

import com.example.busbooking.model.Bus;
import com.example.busbooking.service.BusService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/buses")
public class BusController {

  @Autowired private BusService busService;

  @GetMapping("/search")
  public String searchForm() { return "bus/search"; }

  @PostMapping("/search")
  public String doSearch(String source, String destination,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate travelDate,
                         Model model) {
    List<Bus> results = busService.search(source, destination, travelDate);
    model.addAttribute("buses", results);
    return "bus/search";
  }
}


