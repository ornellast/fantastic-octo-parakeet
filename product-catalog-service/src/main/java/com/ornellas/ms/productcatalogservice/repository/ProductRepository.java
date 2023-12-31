package com.ornellas.ms.productcatalogservice.repository;

import com.ornellas.ms.productcatalogservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
