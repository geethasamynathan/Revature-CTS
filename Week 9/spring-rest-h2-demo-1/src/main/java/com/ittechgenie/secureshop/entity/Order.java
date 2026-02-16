package com.ittechgenie.secureshop.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private AppUser user;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() { return id; }
    public AppUser getUser() { return user; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<OrderItem> getItems() { return items; }

    public void setUser(AppUser user) { this.user = user; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
