package com.ittechgenie.secureshop.service;

import com.ittechgenie.secureshop.entity.Product;
import com.ittechgenie.secureshop.exception.NotFoundException;
import com.ittechgenie.secureshop.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> list() {
        return repo.findAll();
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    public Product update(Long id, Product p) {
        var existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found: " + id));

        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        existing.setStock(p.getStock());
        return repo.save(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Product not found: " + id);
        }
        repo.deleteById(id);
    }
}
