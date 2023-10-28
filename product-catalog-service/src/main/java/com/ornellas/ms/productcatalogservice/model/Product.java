package com.ornellas.ms.productcatalogservice.model;

import com.ornellas.ms.productcatalogservice.model.enums.ProductType;
import com.ornellas.ms.productcatalogservice.model.enums.Unit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "product_catalog", name = "products")
public final class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    Set<ProductIngredient> productIngredientList;

    public Set<ProductIngredient> getProductIngredientList() {
        if(productIngredientList == null) {
            return Set.of();
        }
        return Collections.unmodifiableSet(productIngredientList);
    }

    public void addIngredient(ProductIngredient productIngredient){
        productIngredient.setProduct(this);
        if(productIngredientList == null){
            productIngredientList = new HashSet<>();
        }
        productIngredientList.add(productIngredient);
    }
}
