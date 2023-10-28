package com.ornellas.ms.productcatalogservice.kafka.publisher;

import com.ornellas.ms.productcatalogservice.converter.ProductConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.kafka.EventPublisher;
import com.ornellas.ms.productcatalogservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductPublisher {
    public static final String PRODUCT_TOPIC = "product-catalog-service.product";

    private final EventPublisher<ExternalProduct> eventPublisher;

    public ProductPublisher(EventPublisher<ExternalProduct> eventBusPublisher) {
        this.eventPublisher = eventBusPublisher;
    }

    public void publish(Product product) {
        eventPublisher.publish(PRODUCT_TOPIC,
            product.getId().toString(),
            ProductConverter.toExternalProduct(product)
        );
    }
}
