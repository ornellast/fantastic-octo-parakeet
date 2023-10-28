package com.ornellas.ms.productcatalogservice.converter;

import com.ornellas.ms.productcatalogservice.dto.ExternalProductIngredient;
import com.ornellas.ms.productcatalogservice.model.ProductIngredient;

import java.util.Set;
import java.util.stream.Collectors;

public final class ProductIngredientConverter {
    private ProductIngredientConverter() {

    }

    public static ExternalProductIngredient toExternalProductIngredient(ProductIngredient productIngredient) {
        return new ExternalProductIngredient(
            productIngredient.getProduct().getId(),
            productIngredient.getIngredient().getId(),
            productIngredient.getIngredient().getName(),
            productIngredient.getAmount()
        );
    }

    public static Set<ExternalProductIngredient> toExternalProductIngredient(Set<ProductIngredient> productIngredientList) {
        return productIngredientList.stream()
            .map(ProductIngredientConverter::toExternalProductIngredient)
            .collect(Collectors.toUnmodifiableSet());
    }
}
