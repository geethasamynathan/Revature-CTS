package com.ittechgenie.secureshop.repo;

import com.ittechgenie.secureshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}