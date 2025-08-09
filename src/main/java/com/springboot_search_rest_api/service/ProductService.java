package com.springboot_search_rest_api.service;

import com.springboot_search_rest_api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    public List<Product> searchProductsSql(String query);

    Product createProducts(Product product);
}
