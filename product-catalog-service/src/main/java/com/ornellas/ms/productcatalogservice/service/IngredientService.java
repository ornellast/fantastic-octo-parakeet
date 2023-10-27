package com.ornellas.ms.productcatalogservice.service;

import com.ornellas.ms.productcatalogservice.converter.IngredientConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalIngredient;
import com.ornellas.ms.productcatalogservice.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class IngredientService {

    private final com.ornellas.ms.productcatalogservice.repository.IngredientRepository repository;

    public IngredientService(com.ornellas.ms.productcatalogservice.repository.IngredientRepository repository) {
        this.repository = repository;
    }

    public List<ExternalIngredient> findAll() {
        return repository.findAll()
                .stream()
                .map(IngredientConverter::toExternalIngredient)
                .toList();
    }

    public Ingredient persistIngredient(Ingredient product) {
        return repository.save(product);
    }

    public Optional<Ingredient> findById(UUID id) {
        return repository.findById(id);
    }
}
