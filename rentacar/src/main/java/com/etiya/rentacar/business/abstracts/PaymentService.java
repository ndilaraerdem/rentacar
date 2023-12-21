package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.responses.payment.CreatePaymentResponse;

public interface PaymentService {
CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest);
}

