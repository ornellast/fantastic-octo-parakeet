package com.ornellas.ms.productcatalogservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ornellas.ms.productcatalogservice.model.enums.Unit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "product_catalog", name = "ingredients")
public final class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(nullable = false, precision =5)
    private Double caloriesPerUnit;
}
