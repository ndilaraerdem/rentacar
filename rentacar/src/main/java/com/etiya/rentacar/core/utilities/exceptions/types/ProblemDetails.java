package com.etiya.rentacar.core.utilities.exceptions.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails { //rfce standarts
    private String title;
    private String detail;
    private String status;
    private String type;
}
