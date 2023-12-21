package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entites.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
