package com.example.lesson3.repository;

import com.example.lesson3.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private Map<Long, Product> productDb;

    public ProductRepository() {
        this.productDb = new ConcurrentHashMap<>();
        productDb.put(1l, Product.builder()
                .id(1l)
                .description("Bulka")
                .coast(25)
                .build());
    }

    public List<Product> findAll() {
        return productDb.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Product> findById(Long id) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }
    public Optional<Product> findByDescription(String des) {
        return productDb.values().stream()
                .filter(it -> Objects.equals(it.getDescription(), des))
                .findFirst();
    }

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(productDb.size() + 1L);
        }
        productDb.put(product.getId(), product);
    }
}