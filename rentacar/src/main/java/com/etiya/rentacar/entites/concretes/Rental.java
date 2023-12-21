package com.etiya.rentacar.entites.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
public class Rental {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "car_id")
    private int carId;
    @Column(name = "date_started")
    private LocalDateTime dateStarted;
    @Column(name = "rented_for_days")
    private int rentedForDays;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "rental")
    List<Payment> paymentList;

}
