package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeleteColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdateColorResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperManager;
import com.etiya.rentacar.dataaccess.abstracts.ColorRepository;
import com.etiya.rentacar.entites.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ColorManager implements ColorService {
    ColorRepository colorRepository;
    ModelMapperManager modelMapperService;
    @Override
    public CreateColorResponse add(CreateColorRequest createColorRequest) {
        Color color = modelMapperService.forRequest().map(createColorRequest, Color.class);

        Color createdColor = colorRepository.save(color);

        return modelMapperService.forResponse().map(createdColor, CreateColorResponse.class);    }

    @Override
    public UpdateColorResponse update(UpdateColorRequest updateColorRequest) {
        Color color = modelMapperService.forRequest().map(updateColorRequest, Color.class);
        Color updatedColor = colorRepository.save(color);
        return modelMapperService.forResponse().map(updatedColor, UpdateColorResponse.class);
    }

    @Override
    public DeleteColorResponse delete(int id) {
        Color colorToDelete = new Color();
        colorToDelete.setId(id);
        colorRepository.delete(colorToDelete);
        DeleteColorResponse response = new DeleteColorResponse();
        response.setId(id);
        return response;
    }

    @Override
    public List<GetAllColorResponse> getAll() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream().map(color-> this.modelMapperService.forResponse()
                .map(color, GetAllColorResponse.class)).toList();
    }

    @Override
    public Optional<Color> getById(int id) {
        return colorRepository.findById(id);
    }

}
