package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entites.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    int countByBrandId(int brandId);
}
