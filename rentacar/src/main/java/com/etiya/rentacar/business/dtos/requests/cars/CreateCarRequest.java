package com.etiya.rentacar.business.dtos.requests.cars;

import com.etiya.rentacar.entites.concretes.Brand;
import com.etiya.rentacar.entites.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private double dailyPrice;
    private int modelYear;
    private String description;
    private int state;
    private int brandId;
    private int colorId;
}