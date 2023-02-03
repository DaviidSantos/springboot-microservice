package com.daviidsantos.orderservice.controller;

import com.daviidsantos.orderservice.dto.OrderRequest;
import com.daviidsantos.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest request) {
        service.placeOrder(request);
        return "Order Placed Successfully!";
    }
}
