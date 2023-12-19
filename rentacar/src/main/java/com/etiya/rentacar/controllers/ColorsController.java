package com.etiya.rentacar.controllers;

import com.etiya.rentacar.business.abstracts.ColorService;
import com.etiya.rentacar.business.dtos.requests.colors.CreateColorRequest;
import com.etiya.rentacar.business.dtos.requests.colors.UpdateColorRequest;
import com.etiya.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.etiya.rentacar.business.dtos.responses.colors.CreateColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.DeleteColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.GetAllColorResponse;
import com.etiya.rentacar.business.dtos.responses.colors.UpdateColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
public class ColorsController {
    ColorService colorService;
    @PostMapping
    public CreateColorResponse add(@RequestBody @Valid CreateColorRequest createColorRequest){
        return colorService.add(createColorRequest);
    }
    @GetMapping
    public ResponseEntity<List<GetAllColorResponse>> getAll(){
        return ResponseEntity.ok(colorService.getAll());
    }
    @PutMapping
    public UpdateColorResponse add(@RequestBody @Valid UpdateColorRequest updateColorRequest){
        return colorService.update(updateColorRequest);
    }
    @DeleteMapping
    public DeleteColorResponse delete(@RequestBody int id){
        return colorService.delete(id);
    }
}
