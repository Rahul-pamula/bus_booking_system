package com.example.busbooking.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "bus_id", nullable = false)
  private Bus bus;

  @Min(1)
  @Column(nullable = false)
  private int seats;

  @NotNull
  @Column(nullable = false)
  private LocalDateTime bookedAt = LocalDateTime.now();

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
  public Bus getBus() { return bus; }
  public void setBus(Bus bus) { this.bus = bus; }
  public int getSeats() { return seats; }
  public void setSeats(int seats) { this.seats = seats; }
  public LocalDateTime getBookedAt() { return bookedAt; }
  public void setBookedAt(LocalDateTime bookedAt) { this.bookedAt = bookedAt; }
}


