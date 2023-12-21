package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.responses.payment.CreatePaymentResponse;
import com.etiya.rentacar.business.rules.payments.PaymentBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.PaymentRepository;
import com.etiya.rentacar.entites.concretes.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    PaymentRepository paymentRepository;
    ModelMapperService modelMapperService;
    PaymentBusinessRules paymentBusinessRules;

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) {

        paymentBusinessRules.paymentResultFromPosShouldBeSuccessful(createPaymentRequest);

        Payment payment = modelMapperService.forRequest().map(createPaymentRequest, Payment.class);

        Payment createdPayment = paymentRepository.save(payment);

        return modelMapperService.forResponse().map(createdPayment, CreatePaymentResponse.class);
    }

}
