package com.ittechgenie.secureshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name is required")
    @Column(nullable=false)
    private String name;

    @Min(value=1, message="Price must be >= 1")
    private double price;

    @Min(value=0, message="Stock must be >= 0")
    private int stock;

    public Product() {}

    public Product(String name, double price, int stock) {
        this.name = name; this.price = price; this.stock = stock;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }
}
