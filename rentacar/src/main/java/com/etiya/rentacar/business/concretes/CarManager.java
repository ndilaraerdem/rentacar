package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.cars.CreateCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.DeleteCarResponse;
import com.etiya.rentacar.business.dtos.responses.cars.GetAllCarsResponse;
import com.etiya.rentacar.business.dtos.responses.cars.UpdateCarResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.CarRepository;
import com.etiya.rentacar.entites.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    CarRepository carRepository;
    ModelMapperService modelMapperService;
    ColorService colorService;
    BrandService brandService;
    @Override
    public CreateCarResponse add(CreateCarRequest createCarRequest) {
        int carCountByBrandId = carRepository.countByBrandId(createCarRequest.getBrandId());
        if (carCountByBrandId >= 10){
            throw new RuntimeException("Aynı marka arabadan en fazla 10 adet ekleyebilirsiniz.");
        }
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        Car createdCar = carRepository.save(car);
        CreateCarResponse response = modelMapperService.forResponse().map(createdCar, CreateCarResponse.class);
//        Color carColor = colorService.getById(createCarRequest.getColorId()).orElseThrow(RuntimeException::new);
//        Brand carBrand = brandService.getById(createCarRequest.getBrandId()).orElseThrow(RuntimeException::new);

//        response.setColorName(carColor.getName());
//        response.setBrandName(carBrand.getName());
        return response;
    }

    @Override
    public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest,Car.class);
        Car updatedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(updatedCar, UpdateCarResponse.class);
    }

    @Override
    public DeleteCarResponse delete(int id) {
        Car carToDelete = new Car();
        carToDelete.setId(id);
        carRepository.delete(carToDelete);
        DeleteCarResponse response = new DeleteCarResponse();
        response.setId(id);
        return response;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll(); //veri tabanımızdaki tüm arabaları çekiyoruz.
        return cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

}
