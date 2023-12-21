package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@Data
@AllArgsConstructor

public class ValidationProblemDetails extends ProblemDetails {
    public ValidationProblemDetails() {
        setTitle("validation rule violation");
        setDetail("validation problem");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("500");
    }

    private Map<String,String> errors;
}
