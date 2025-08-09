package com.springboot_search_rest_api.service.impl;

import com.springboot_search_rest_api.entity.Product;
import com.springboot_search_rest_api.repository.ProductRepository;
import com.springboot_search_rest_api.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }
    @Override
    public List<Product> searchProductsSql(String query) {
        List<Product> products = productRepository.searchProductsSql(query);
        return products;
    }
    @Override
    public Product createProducts(Product product) {
        return productRepository.save(product);
    }
}
