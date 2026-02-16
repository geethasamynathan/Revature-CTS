package com.ittechgenie.secureshop.service;

import com.ittechgenie.secureshop.dto.CreateOrderRequest;
import com.ittechgenie.secureshop.entity.*;
import com.ittechgenie.secureshop.exception.*;
import com.ittechgenie.secureshop.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;

    public OrderService(UserRepository userRepo, ProductRepository productRepo, OrderRepository orderRepo) {
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @Transactional
    public Order placeOrder(String username, CreateOrderRequest req) {

        AppUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found: " + username));

        Order order = new Order();
        order.setUser(user);

        req.items().forEach(itemReq -> {
            Product product = productRepo.findById(itemReq.productId())
                    .orElseThrow(() -> new NotFoundException("Product not found: " + itemReq.productId()));

            if (product.getStock() < itemReq.quantity()) {
                throw new ApiException("Insufficient stock for product: " + product.getName());
            }

            product.setStock(product.getStock() - itemReq.quantity());
            productRepo.save(product);

            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(product);
            oi.setQuantity(itemReq.quantity());

            order.getItems().add(oi);
        });

        return orderRepo.save(order);
    }
}
