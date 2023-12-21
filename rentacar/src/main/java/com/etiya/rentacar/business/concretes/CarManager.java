package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.*;
import com.etiya.rentacar.business.rules.cars.CarBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.entites.concretes.Car;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    CarRepository carRepository;
    ModelMapperService modelMapperService;
    CarBusinessRules carBusinessRules;

    @Override
    public CreateCarResponse add(CreateCarRequest createCarRequest) {
        carBusinessRules.eachBrandCanContainMaxTenCars(createCarRequest.getBrandId());

        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        Car createdCar = carRepository.save(car);
        return modelMapperService.forResponse().map(createdCar, CreateCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest,Car.class);
        Car updatedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(updatedCar, UpdateCarResponse.class);
    }

    @Override
    public DeleteCarResponse delete(int id) {
        Car carToDelete = new Car();
        carToDelete.setId(id);
        carRepository.delete(carToDelete);
        DeleteCarResponse response = new DeleteCarResponse();
        response.setId(id);
        return response;
    }

    @Override
    public Optional<Car> getById(int id) {
        return carRepository.findById(id);
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll(); //veri tabanımızdaki tüm arabaları çekiyoruz.
        return cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    @Transactional
    public CreateMaintenanceResponse sendCarToMaintenance(CreateMaintenanceRequest createMaintenanceRequest) {
       Optional<Car> car = carRepository.findById(createMaintenanceRequest.getCarId());
       carBusinessRules.carCanBeSentToMaintenanceIfItIsAvailable(createMaintenanceRequest.getCarId());
       car.get().setState(2);

       return modelMapperService.forResponse().map(car, CreateMaintenanceResponse.class);
    }

}
