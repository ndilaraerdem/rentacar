package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entites.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
