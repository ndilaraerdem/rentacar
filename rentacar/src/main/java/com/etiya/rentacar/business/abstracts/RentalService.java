package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rentals.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.CreateRentalResponse;

public interface RentalService {
    CreateRentalResponse add(CreateRentalRequest createRentalRequest);
}
