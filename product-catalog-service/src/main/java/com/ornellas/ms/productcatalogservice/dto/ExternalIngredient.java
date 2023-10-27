package com.ornellas.ms.productcatalogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ornellas.ms.productcatalogservice.model.enums.ProductType;
import com.ornellas.ms.productcatalogservice.model.enums.Unit;

import java.time.Instant;
import java.util.UUID;

public record ExternalIngredient(
        UUID id,
        String name,
        Unit unit,
        @JsonProperty("calories_per_unit")
        Double caloriesPerUnit,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("updated_at")
        Instant updatedAt
) {
};
