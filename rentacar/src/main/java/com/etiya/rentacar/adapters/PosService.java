package com.etiya.rentacar.adapters;

import org.springframework.stereotype.Service;

@Service
public interface PosService {
    public boolean pay(PaymentData paymentData);
}
