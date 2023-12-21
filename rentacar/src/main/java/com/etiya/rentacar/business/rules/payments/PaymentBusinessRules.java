package com.etiya.rentacar.business.rules.payments;

import com.etiya.rentacar.adapters.PaymentData;
import com.etiya.rentacar.adapters.PosService;
import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.etiya.rentacar.business.messages.PaymentBusinessMessages;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentBusinessRules {
    PosService posService;
    ModelMapperService modelMapperService;
    public void  paymentResultFromPosShouldBeSuccessful(CreatePaymentRequest createPaymentRequest){
        PaymentData paymentData = modelMapperService.forResponse().map(createPaymentRequest, PaymentData.class) ;
        var bankResult = posService.pay(paymentData);
        if (!bankResult){
            throw new BusinessException(PaymentBusinessMessages.PaymentResultFromPosShouldBeSuccessful);
        }
    }
}
