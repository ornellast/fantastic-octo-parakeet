package com.ornellas.ms.productcatalogservice.controller;

import com.ornellas.ms.productcatalogservice.converter.ProductConverter;
import com.ornellas.ms.productcatalogservice.dto.ExternalProduct;
import com.ornellas.ms.productcatalogservice.service.ProductService;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.persistence.EntityNotFoundException;
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
            service.findAll().stream().map(ProductConverter::toExternalProduct).toList()
        );
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ExternalProduct dto) {
        try {
            service.persistProduct(dto);
            return ResponseEntity.ok().build();

        } catch (EntityNotFoundException ex) {
            return ResponseEntity.badRequest().body("One or more ingredients has wrong id");
        } catch (InvalidRequestStateException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity put(@RequestBody ExternalProduct dto, @PathVariable("id") UUID id) {
        try {
            service.updateProduct(dto, id);
            return ResponseEntity.ok().build();
        } catch (InvalidRequestStateException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }

    }
}
