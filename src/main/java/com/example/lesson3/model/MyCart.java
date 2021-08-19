package com.example.lesson3.model;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Getter
public class MyCart {

    private final Map<Product, Integer> myProducts;

    public MyCart(){
        this.myProducts = new ConcurrentHashMap<>();
    }

    public void add(Product product) {
        try {
            if (myProducts.get(product) == null) {
                myProducts.put(product, 1);
            } else {
                myProducts.replace(product, myProducts.get(product) + 1);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void delete(Product product) {
        try {
            if (myProducts.get(product) > 1) {
                myProducts.replace(product, myProducts.get(product) - 1);
            } else {
                myProducts.remove(product);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


}