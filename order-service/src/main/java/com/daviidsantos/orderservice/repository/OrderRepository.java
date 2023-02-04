package com.daviidsantos.orderservice.repository;

import com.daviidsantos.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
