package com.ornellas.ms.productcatalogservice.service;

import com.ornellas.ms.productcatalogservice.converter.ProductConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.model.Product;
import com.ornellas.ms.productcatalogservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ExternalProduct> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductConverter::toExternalProduct)
                .toList();
    }

    public Product persistProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }
}
