package com.ornellas.ms.productcatalogservice.controller;

import com.ornellas.ms.productcatalogservice.converter.IngredientConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalIngredient;
import com.ornellas.ms.productcatalogservice.service.IngredientService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "ingredients")
public class IngredientController {


    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ExternalIngredient>> listAll() {
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ExternalIngredient dto) {
        service.persistIngredient(IngredientConverter.from(dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity put(@RequestBody ExternalIngredient dto, @PathVariable("id") UUID id) {
        val ingredient = service.findById(id).get();
        ingredient.setName(dto.name());
        ingredient.setUnit(dto.unit());
        ingredient.setCaloriesPerUnit(dto.caloriesPerUnit());
        service.persistIngredient(ingredient);
        return ResponseEntity.ok().build();

    }
}
