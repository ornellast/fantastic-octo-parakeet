package com.ornellas.ms.productcatalogservice.converter;

import com.ornellas.ms.productcatalogservice.dto.ExternalIngredient;
import com.ornellas.ms.productcatalogservice.model.Ingredient;

public class IngredientConverter {
    private IngredientConverter() {

    }

    public static Ingredient from(ExternalIngredient external) {
        return new Ingredient(external.id(), external.name(), external.unit(), external.caloriesPerUnit());
    }

    public static ExternalIngredient toExternalIngredient(Ingredient ingredient) {
        return new ExternalIngredient(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getUnit(),
                ingredient.getCaloriesPerUnit(),
                ingredient.getCreatedAt(),
                ingredient.getUpdatedAt()
        );
    }
}
