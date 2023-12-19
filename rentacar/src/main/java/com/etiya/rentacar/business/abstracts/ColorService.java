package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeleteColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdateColorResponse;

import java.util.List;

public interface ColorService {
    CreateColorResponse add(CreateColorRequest createColorRequest);
    UpdateColorResponse update(UpdateColorRequest updateColorRequest);
    DeleteColorResponse delete(int id);
    List<GetAllColorResponse> getAll();

}
