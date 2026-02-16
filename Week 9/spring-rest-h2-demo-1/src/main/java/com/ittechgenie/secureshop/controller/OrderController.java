package com.ittechgenie.secureshop.controller;

import com.ittechgenie.secureshop.dto.CreateOrderRequest;
import com.ittechgenie.secureshop.entity.Order;
import com.ittechgenie.secureshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Order> place(@RequestBody @Valid CreateOrderRequest req,
                                       Authentication auth) {
        Order created = service.placeOrder(auth.getName(), req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
