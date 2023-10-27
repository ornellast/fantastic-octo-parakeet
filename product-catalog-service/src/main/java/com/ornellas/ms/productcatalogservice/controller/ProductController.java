package com.ornellas.ms.productcatalogservice.controller;

import com.ornellas.ms.productcatalogservice.converter.ProductConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.service.ProductService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ExternalProduct>> listAll() {
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ExternalProduct dto) {
        val be = ProductConverter.from(dto);
        service.persistProduct(be);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity put(@RequestBody ExternalProduct dto, @PathVariable("id") UUID id) {
        val be = service.findById(id).get();
        be.setName(dto.name());
        be.setType(dto.type());
        service.persistProduct(be);
        return ResponseEntity.ok().build();

    }
}
