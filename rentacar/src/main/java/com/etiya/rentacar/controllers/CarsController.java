package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreateCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeleteCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarsResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdateCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private CarService carService;

    @PostMapping
    public CreateCarResponse add(@RequestBody @Valid CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }
    @GetMapping
    public ResponseEntity<List<GetAllCarsResponse>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }
    
    @PutMapping
    public UpdateCarResponse add(@RequestBody @Valid UpdateCarRequest updateCarRequest){
        return carService.update(updateCarRequest);
    }
    @DeleteMapping
    public DeleteCarResponse delete(@RequestBody int id){
        return carService.delete(id);
    }
}
