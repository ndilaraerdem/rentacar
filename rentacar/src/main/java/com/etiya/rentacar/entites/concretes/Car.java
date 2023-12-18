package com.etiya.rentacar.entites.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY);
    @Column(name = "id")
    private int id;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "description")
    private String description;
    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}

