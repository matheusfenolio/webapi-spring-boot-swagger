package com.api.api.controller;

import com.api.api.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.api.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    ProductService productService = new ProductService();
    public final List<Product> products = productService.initProducts();

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getSpecificProducts(@PathVariable("id") Integer id){
        return products.stream().filter(product -> product.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @PostMapping("/products")
    public Object insertProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }

    @PutMapping("/products")
    public Object updateProduct(@RequestBody Product product){
        products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .forEach(product1 -> { product1.setName(product.getName());  product1.setDescription(product.getDescription());});
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Integer id){
        products.removeIf(p -> p.getId().equals(id));
    }

}
