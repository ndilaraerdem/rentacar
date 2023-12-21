package com.etiya.rentacar.business.dtos.responses.payment;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResponse {
    private int rentalId;
    private double amount;
}
