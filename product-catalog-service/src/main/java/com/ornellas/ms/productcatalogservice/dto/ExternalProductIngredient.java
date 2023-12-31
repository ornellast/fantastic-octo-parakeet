package com.ornellas.ms.productcatalogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ExternalProductIngredient(
    @JsonProperty("ingredient_id")
    UUID ingredientId,
    String ingredientName,
    Double amount
) {
}
