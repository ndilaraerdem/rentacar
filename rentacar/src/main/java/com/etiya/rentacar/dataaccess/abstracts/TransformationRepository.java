package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entites.concretes.Transformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformationRepository extends JpaRepository<Transformation, Integer> {
}
