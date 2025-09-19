package com.example.busbooking.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "buses")
public class Bus {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String source;

  @NotBlank
  @Column(nullable = false)
  private String destination;

  @NotNull
  private LocalDateTime departureTime;

  @NotNull
  private LocalDateTime arrivalTime;

  @Min(1)
  @Column(nullable = false)
  private int totalSeats;

  @Column(nullable = false)
  private int availableSeats;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getSource() { return source; }
  public void setSource(String source) { this.source = source; }
  public String getDestination() { return destination; }
  public void setDestination(String destination) { this.destination = destination; }
  public LocalDateTime getDepartureTime() { return departureTime; }
  public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
  public LocalDateTime getArrivalTime() { return arrivalTime; }
  public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
  public int getTotalSeats() { return totalSeats; }
  public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
  public int getAvailableSeats() { return availableSeats; }
  public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}


