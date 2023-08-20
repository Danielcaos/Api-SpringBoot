package com.api.database.controller;


import com.api.database.model.Product;
import com.api.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{name}")
    public Product getAllProducts(@PathVariable String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        Product product = productOptional.get();
        return product;
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        Optional<Product> productOptional = productRepository.findByName(product.getName());
        if(productOptional.isPresent()){
            Product product1 = productOptional.get();
            product.setCount(product.getCount()+1);
        }
        return productRepository.save(product);
    }

}
