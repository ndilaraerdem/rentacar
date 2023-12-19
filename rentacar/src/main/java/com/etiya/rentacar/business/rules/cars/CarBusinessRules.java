package com.etiya.rentacar.business.rules.cars;

import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    CarRepository carRepository;

    public void eachBrandCanContainMaxTenCars(int brandId) {
        int carCountInGivenBrand = carRepository.countByBrandId(brandId);
        if (carCountInGivenBrand >= 10){
            throw new RuntimeException("Each brand can contains max 10 cars");
        }
    }
}
