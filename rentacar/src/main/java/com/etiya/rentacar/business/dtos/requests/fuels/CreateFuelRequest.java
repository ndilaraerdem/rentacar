package com.etiya.rentacar.business.dtos.requests.fuels;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFuelRequest {
    @Size(min = 2, max = 30)
    private String name;
}
