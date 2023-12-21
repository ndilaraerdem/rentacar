package com.etiya.rentacar.business.rules.rentals;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataaccess.abstracts.RentalRepository;
import com.etiya.rentacar.entites.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RentalBusinessRules {
    RentalRepository rentalRepository;
    CarService carService;

    public void carShouldBeAvailableToRent(int carId) {
        Car car = carService.getById(carId).orElseThrow(()-> new BusinessException("The car doesn't exist with id: "+ carId));
        if (car.getState() != 1){
            throw new BusinessException("You cant rent this car because it is not available");
        }
    }

}
