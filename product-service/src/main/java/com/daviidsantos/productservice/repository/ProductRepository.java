package com.daviidsantos.productservice.repository;

import com.daviidsantos.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
