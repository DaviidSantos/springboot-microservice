package com.daviidsantos.productservice.controller;

import com.daviidsantos.productservice.dto.ProductRequest;
import com.daviidsantos.productservice.dto.ProductResponse;
import com.daviidsantos.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request) {
        service.createProduct(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return service.getAllProducts();
    }
}
