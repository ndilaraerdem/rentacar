package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreateCarResponse;
import com.etiya.rentacar.business.dtos.responses.fuels.CreateFuelResponse;

public interface FuelService {
    CreateFuelResponse add(CreateFuelRequest createFuelRequest);

}
