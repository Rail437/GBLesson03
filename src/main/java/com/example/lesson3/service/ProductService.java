package com.example.lesson3.service;

import com.example.lesson3.model.Person;
import com.example.lesson3.model.Product;
import com.example.lesson3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public Product findByName(String name){
        return productRepository.findByDescription(name).orElseThrow(() -> new NoSuchElementException());
    }
    public void save(Product product) {
        productRepository.save(product);
    }
}