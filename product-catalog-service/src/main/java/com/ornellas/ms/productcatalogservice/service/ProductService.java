package com.ornellas.ms.productcatalogservice.service;

import com.ornellas.ms.productcatalogservice.converter.ProductConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.model.Product;
import com.ornellas.ms.productcatalogservice.repository.ProductRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.persistence.EntityNotFoundException;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class ProductService {

    private final ProductRepository repository;

    private final IngredientService ingredientService;

    public ProductService(ProductRepository repository, IngredientService ingredientService) {
        this.repository = repository;
        this.ingredientService = ingredientService;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product updateProduct(ExternalProduct externalProduct, UUID id) {

        if (!id.equals(externalProduct.id())) {
            throw new InvalidRequestStateException("The path Id and the product:id don't match each other");
        }

        val optionalProduct = findById(id);

        if (optionalProduct.isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }
        val managedEntity = optionalProduct.get();
        ProductConverter.fromExternalIntoManagedEntity(externalProduct, ingredientService, managedEntity);
        return repository.save(managedEntity);
    }

    public Optional<Product> findById(UUID id) {
        return repository.findById(id);
    }

    public Product persistProduct(ExternalProduct dto) {
        val product = ProductConverter.from(dto, ingredientService);
        if (product.getProductIngredientList().isEmpty()){
            throw new InvalidRequestStateException("The product has to have an ingredient list");
        }
        return repository.save(product);
    }
}
