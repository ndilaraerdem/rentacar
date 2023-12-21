package com.etiya.rentacar.business.dtos.responses.fuels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFuelResponse {
    private int id;
    private String name;
}
