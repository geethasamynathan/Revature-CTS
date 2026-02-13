package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ProductRequestDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // ✅ GET all
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        List<ProductResponseDto> list = service.getAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();

        return ResponseEntity.ok(list);
    }

    // ✅ GET one
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getOne(@PathVariable Long id) {
        Product p = service.getById(id);
        return ResponseEntity.ok(ProductMapper.toResponse(p));
    }

    // ✅ POST create
    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody ProductRequestDto dto) {
        Product entity = ProductMapper.toEntity(dto);
        Product saved = service.create(entity);

        URI location = URI.create("/api/products/" + saved.getId());
        return ResponseEntity.created(location).body(ProductMapper.toResponse(saved));
    }

    // ✅ PUT full update
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateFull(@PathVariable Long id,
                                                        @Valid @RequestBody ProductRequestDto dto) {
        Product updated = service.updateFull(id, dto);
        return ResponseEntity.ok(ProductMapper.toResponse(updated));
    }

    // ✅ PATCH stock only
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductResponseDto> patchStock(@PathVariable Long id,
                                                        @RequestBody Map<String, Integer> body) {
        int stock = body.getOrDefault("stock", 0);
        Product updated = service.updateStockOnly(id, stock);
        return ResponseEntity.ok(ProductMapper.toResponse(updated));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
