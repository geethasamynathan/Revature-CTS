package com.ittechgenie.secureshop.controller;

import com.ittechgenie.secureshop.entity.Product;
import com.ittechgenie.secureshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> list() {
        return service.list();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product p) {
        Product saved = service.create(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody @Valid Product p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
