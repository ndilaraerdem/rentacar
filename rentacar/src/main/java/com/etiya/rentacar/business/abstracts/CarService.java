package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreateCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeleteCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarsResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdateCarResponse;

import java.util.List;

public interface CarService {
    CreateCarResponse add(CreateCarRequest createCarRequest);
    UpdateCarResponse update (UpdateCarRequest updateCarRequest);

    DeleteCarResponse delete(int id);

    List<GetAllCarsResponse> getAll();
}
