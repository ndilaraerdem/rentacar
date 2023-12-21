package com.etiya.rentacar.business.dtos.requests.transformations;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransformationRequest {
    @Size(min = 2, max = 30)
    private String name;
}
