package com.ornellas.ms.productcatalogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ExternalProductIngredient(
    @JsonProperty("product_id")
    UUID productId,
    @JsonProperty("ingredient_id")
    UUID ingredientId,
    String ingredientName,
    Double amount
) {
}
