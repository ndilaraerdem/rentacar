package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.rentacar.business.dtos.responses.fuels.CreateFuelResponse;
import com.etiya.rentacar.business.dtos.responses.transformations.CreateTransformationResponse;

public interface TransformationService {
    CreateTransformationResponse add(CreateTransformationRequest createTransformationRequest);

}
