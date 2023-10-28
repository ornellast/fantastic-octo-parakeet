package com.ornellas.ms.productcatalogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ornellas.ms.productcatalogservice.model.enums.ProductType;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record ExternalProduct(
        UUID id,
        String name,
        ProductType type,
        Set<ExternalProductIngredient> ingredients,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("updated_at")
        Instant updatedAt
) {
};
