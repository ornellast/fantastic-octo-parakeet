package com.ornellas.ms.productcatalogservice.service;

import com.ornellas.ms.productcatalogservice.converter.IngredientConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalIngredient;
import com.ornellas.ms.productcatalogservice.model.Ingredient;
import com.ornellas.ms.productcatalogservice.repository.IngredientRepository;
import com.ornellas.ms.productcatalogservice.service.operation.Search;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class IngredientService implements Search<Ingredient, UUID> {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingredient> findAllById(Iterable<UUID> uuids) {
        return repository.findAllById(uuids);
    }

    public Ingredient persistIngredient(Ingredient product) {
        return repository.save(product);
    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return repository.findById(id);
    }

}
