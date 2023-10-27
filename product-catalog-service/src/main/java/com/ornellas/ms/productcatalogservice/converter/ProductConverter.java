package com.ornellas.ms.productcatalogservice.converter;

import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.model.Product;

public class ProductConverter {
    private ProductConverter() {

    }

    public static Product from(ExternalProduct external) {
        return new Product(external.id(), external.name(), external.type());
    }

    public static ExternalProduct toExternalProduct(Product product){
        return new ExternalProduct(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
