package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.PaymentService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.CreateRentalResponse;
import com.etiya.rentacar.business.rules.rentals.RentalBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.RentalRepository;
import com.etiya.rentacar.entites.concretes.Car;
import com.etiya.rentacar.entites.concretes.Payment;
import com.etiya.rentacar.entites.concretes.Rental;
import com.etiya.rentacar.outServices.IsBankService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    RentalRepository rentalRepository;
    CarService carService;
    ModelMapperService modelMapperService;
    RentalBusinessRules rentalBusinessRules;
    PaymentService paymentService;

    @Override
    @Transactional
    public CreateRentalResponse add(CreateRentalRequest createRentalRequest) {

        rentalBusinessRules.carShouldBeAvailableToRent(createRentalRequest.getCarId());

        Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        Rental createdRental = rentalRepository.save(rental);

        CreatePaymentRequest createPaymentRequest = modelMapperService.forResponse().map(createRentalRequest, CreatePaymentRequest.class);
        createPaymentRequest.setRentalId(createdRental.getId());
        createPaymentRequest.setAmount(createRentalRequest.getTotalPrice());
        paymentService.add(createPaymentRequest);

        Optional<Car> car = carService.getById(createRentalRequest.getCarId());
        car.get().setState(3);

        return modelMapperService.forResponse().map(createdRental, CreateRentalResponse.class);
        }


    }

