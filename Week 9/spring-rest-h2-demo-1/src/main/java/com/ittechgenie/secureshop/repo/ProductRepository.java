package com.ittechgenie.secureshop.repo;

import com.ittechgenie.secureshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
