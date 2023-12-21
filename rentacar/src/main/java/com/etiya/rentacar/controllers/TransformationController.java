package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.TransformationService;
import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.transformations.CreateTransformationRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.transformations.CreateTransformationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transformations")
@AllArgsConstructor
public class TransformationController {
    TransformationService transformationService;
    @PostMapping
    public CreateTransformationResponse add(@RequestBody @Valid CreateTransformationRequest createTransformationRequest){
        return transformationService.add(createTransformationRequest);
    }
}
