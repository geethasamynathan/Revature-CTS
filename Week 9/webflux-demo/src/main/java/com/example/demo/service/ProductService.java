package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	private final Map<Long, Product> db = new ConcurrentHashMap<>();

    public ProductService() {
        // seed data (like real shop catalog)
        db.put(1L, new Product(1L, "Laptop", 65000));
        db.put(2L, new Product(2L, "Mouse", 700));
        db.put(3L, new Product(3L, "Keyboard", 1500));
    }

    // Flux: many products
    public Flux<Product> findAll() {
        return Flux.fromIterable(db.values());
    }

    // Mono: one product or empty
    public Mono<Product> findById(Long id) {
        Product p = db.get(id);
        return (p != null) ? Mono.just(p) : Mono.empty();
    }

    // Mono: create product (0/1 result)
    public Mono<Product> create(Product p) {
        if (p.getId() == null) {
            long newId = db.size() + 1L;
            p.setId(newId);
        }
        db.put(p.getId(), p);
        return Mono.just(p);
    }

    public Mono<Void> delete(Long id) {
        db.remove(id);
        return Mono.empty(); // signals completion
    }
}

