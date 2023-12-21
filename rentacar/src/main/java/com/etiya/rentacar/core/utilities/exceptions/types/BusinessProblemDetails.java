package com.etiya.rentacar.core.utilities.exceptions.types;

import lombok.Data;

@Data
public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business rule violation");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("500");
    }

}
