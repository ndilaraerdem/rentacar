package com.etiya.rentacar.business.rules.cars;

import com.etiya.rentacar.business.messages.CarBusinessMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.entites.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    CarRepository carRepository;

    public void eachBrandCanContainMaxTenCars(int brandId) {
        int carCountInGivenBrand = carRepository.countByBrandId(brandId);
        if (carCountInGivenBrand >= 10){
            throw new BusinessException(CarBusinessMessages.EachBrandCanContainMaxTenCars);
        }
    }
    public void carCanBeSentToMaintenanceIfItIsAvailable(int carId) {
        Car car = carRepository.findById(carId).orElseThrow(()-> new BusinessException(CarBusinessMessages.CarShouldBeExists + carId));
        if (car.getState() == 2){
            throw new BusinessException(CarBusinessMessages.CarCanNotBeSentMaintenanceWithStateMaintenance);
        }
        if (car.getState() == 3){
            throw new BusinessException(CarBusinessMessages.CarCanNotBeSentMaintenanceWithStateRented);
        }
    }

}
