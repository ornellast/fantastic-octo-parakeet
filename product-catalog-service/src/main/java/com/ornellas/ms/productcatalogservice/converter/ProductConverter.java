package com.ornellas.ms.productcatalogservice.converter;

import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.model.Ingredient;
import com.ornellas.ms.productcatalogservice.model.Product;
import com.ornellas.ms.productcatalogservice.model.ProductIngredient;
import com.ornellas.ms.productcatalogservice.service.operation.Search;
import jakarta.persistence.EntityNotFoundException;
import lombok.val;

import java.util.UUID;

public class ProductConverter {
    private ProductConverter() {

    }

    public static Product from(ExternalProduct external, Search<Ingredient, UUID> ingredientSearch) {
        val product = new Product(
            null,
            external.name(),
            external.type(),
            external.amount(),
            external.unit(),
            null);

        if (external.ingredients() == null || external.ingredients().isEmpty()) {
            return product;
        }

        for (val externalProductIngredient : external.ingredients()) {
            val ingredient = ingredientSearch.findById(externalProductIngredient.ingredientId());
            product.addIngredient(
                new ProductIngredient(
                    null,
                    null,
                    ingredient.orElseThrow(EntityNotFoundException::new),
                    externalProductIngredient.amount()
                )
            );
        }

        return product;
    }

    public static void fromExternalIntoManagedEntity(
        ExternalProduct external,
        Search<Ingredient, UUID> ingredientSearch,
        Product managedEntity) {
        val detachedProduct = from(external, ingredientSearch);

        managedEntity.setName(detachedProduct.getName());
        managedEntity.setType(detachedProduct.getType());
        managedEntity.setProductIngredientList(detachedProduct.getProductIngredientList());
    }

    public static ExternalProduct toExternalProduct(Product product) {
        return new ExternalProduct(
            product.getId(),
            product.getName(),
            product.getType(),
            product.getAmount(),
            product.getUnit(),
            ProductIngredientConverter.toExternalProductIngredient(product.getProductIngredientList()),
            product.getCreatedAt(),
            product.getUpdatedAt()

        );
    }
}
