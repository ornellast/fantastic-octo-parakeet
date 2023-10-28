package com.ornellas.ms.productcatalogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ornellas.ms.productcatalogservice.model.enums.ProductType;
import com.ornellas.ms.productcatalogservice.model.enums.Unit;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record ExternalProduct(
    UUID id,
    String name,
    ProductType type,
    Double amount,
    Unit unit,
    Set<ExternalProductIngredient> ingredients,
    @JsonProperty("created_at")
    Instant createdAt,
    @JsonProperty("updated_at")
    Instant updatedAt
) {
};
