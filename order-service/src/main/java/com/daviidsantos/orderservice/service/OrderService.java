package com.daviidsantos.orderservice.service;

import com.daviidsantos.orderservice.dto.OrderLineItemsDto;
import com.daviidsantos.orderservice.dto.OrderRequest;
import com.daviidsantos.orderservice.model.Order;
import com.daviidsantos.orderservice.model.OrderLineItems;
import com.daviidsantos.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {
    private final OrderRepository repository;

    public void placeOrder(OrderRequest request) {
        List<OrderLineItems> orderLineItems = request.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItems)
                .build();

        repository.save(order);
        log.info("Order {} placed!", order.getOrderNumber());
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();
    }
}
