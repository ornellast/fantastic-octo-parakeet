package com.ornellas.ms.productcatalogservice.dto;

import com.ornellas.ms.productcatalogservice.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public record ExternalProduct(
        UUID id,
        String name,
        ProductType type,
        Instant createdAt,
        Instant updatedAt
) {
};
