package com.etiya.rentacar.business.dtos.responses.colors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorResponse {
    private int id;
    private String name;
}
