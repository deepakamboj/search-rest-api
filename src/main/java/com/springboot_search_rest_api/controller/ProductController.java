package com.springboot_search_rest_api.controller;

import com.springboot_search_rest_api.entity.Product;
import com.springboot_search_rest_api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
        return ResponseEntity.ok(productService.searchProducts(query));
        //to bind the value of query parameter-@RequestParam
        //"query"-name of query parameter

    }
    @GetMapping("/searchSql")
    public ResponseEntity<List<Product>> searchProductsSql(@RequestParam("query") String query) {
        return ResponseEntity.ok(productService.searchProductsSql(query));
    }
    @PostMapping
    public ResponseEntity<Product> createProducts(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProducts(product));
    }
}
