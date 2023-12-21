package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import com.etiya.rentacar.core.utilities.exceptions.problemDetails.ProblemDetails;
import lombok.Data;

@Data
public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setTitle("Business rule violation");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("500");
    }

}
