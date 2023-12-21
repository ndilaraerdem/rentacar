package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransformationService;
import com.etiya.rentacar.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.rentacar.business.dtos.responses.transformations.CreateTransformationResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.TransformationRepository;
import com.etiya.rentacar.entites.concretes.Color;
import com.etiya.rentacar.entites.concretes.Transformation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransformationManager implements TransformationService {
    TransformationRepository transformationRepository ;
    ModelMapperService modelMapperService;
    @Override
    public CreateTransformationResponse add(CreateTransformationRequest createTransformationRequest) {
        Transformation transformation = modelMapperService.forRequest().map(createTransformationRequest, Transformation.class);

        Transformation createdTransformation = transformationRepository.save(transformation);

        return modelMapperService.forResponse().map(createdTransformation, CreateTransformationResponse.class);
    }
}
