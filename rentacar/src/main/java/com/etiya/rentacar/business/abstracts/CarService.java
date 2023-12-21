package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.CreateMaintenanceRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.*;
import com.etiya.rentacar.entites.concretes.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    CreateCarResponse add(CreateCarRequest createCarRequest);

    UpdateCarResponse update (UpdateCarRequest updateCarRequest);

    DeleteCarResponse delete(int id);

    Optional<Car> getById(int id);

    List<GetAllCarsResponse> getAll();

    CreateMaintenanceResponse sendCarToMaintenance (CreateMaintenanceRequest createMaintenanceRequest);

}
