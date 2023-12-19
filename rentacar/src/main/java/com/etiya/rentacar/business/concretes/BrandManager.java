package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brands.CreateBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.DeleteBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brands.UpdateBrandResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataaccess.abstracts.BrandRepository;
import com.etiya.rentacar.entites.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    //business rules
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest){
        //business rules

        Brand brand = modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        Brand createdBrand =  brandRepository.save(brand);

        return modelMapperService.forResponse().map(createdBrand,CreateBrandResponse.class);
    }


    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        Brand updatedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(updatedBrand,UpdateBrandResponse.class);
    }

    @Override
    public DeleteBrandResponse delete(int id) {
        Brand brandToDelete = new Brand();
        brandToDelete.setId(id);
        brandRepository.delete(brandToDelete);
        DeleteBrandResponse response = new DeleteBrandResponse();
        response.setId(id);
        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).toList();
    }
}
