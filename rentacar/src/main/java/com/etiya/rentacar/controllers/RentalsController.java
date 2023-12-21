package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.CreateRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController {
    RentalService rentalService;
    @PostMapping
    public CreateRentalResponse add(@RequestBody @Valid CreateRentalRequest createRentalRequest){
        return rentalService.add(createRentalRequest);
    }
}
