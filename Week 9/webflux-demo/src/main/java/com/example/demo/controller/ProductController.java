package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/products")
public class ProductController {
	private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET all products
    @GetMapping
    public Flux<Product> getAll() {
        return service.findAll();
    }

    // GET single product
    // Industry standard: return 404 if not found
    @GetMapping("/{id}")
    public Mono<Product> getOne(@PathVariable Long id) {
        return service.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found: " + id)));
    }

    // POST create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Mono<Product> create(@RequestBody Product p) {
        return service.create(p);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public Mono<Void> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

