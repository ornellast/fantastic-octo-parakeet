package com.ornellas.ms.productcatalogservice.repository;

import com.ornellas.ms.productcatalogservice.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
}
