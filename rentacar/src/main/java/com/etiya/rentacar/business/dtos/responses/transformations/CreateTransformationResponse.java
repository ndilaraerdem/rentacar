package com.etiya.rentacar.business.dtos.responses.transformations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransformationResponse {
    private int id;
    private String name;
}
