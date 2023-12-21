package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuels.CreateFuelResponse;
import com.etiya.rentacar.business.dtos.responses.transformations.CreateTransformationResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.FuelRepository;
import com.etiya.rentacar.entites.concretes.Fuel;
import com.etiya.rentacar.entites.concretes.Transformation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    FuelRepository fuelRepository;
    ModelMapperService modelMapperService;
    @Override
    public CreateFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest, Fuel.class);

        Fuel createdFuel = fuelRepository.save(fuel);

        return modelMapperService.forResponse().map(createdFuel, CreateFuelResponse.class);
    }
}
