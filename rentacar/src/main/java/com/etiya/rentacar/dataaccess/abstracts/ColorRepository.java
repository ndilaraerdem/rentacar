package com.etiya.rentacar.dataaccess.abstracts;

import com.etiya.rentacar.entites.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}
