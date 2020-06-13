package com.api.api.service;

import com.api.api.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> initProducts(){

        List<Product> products = new ArrayList<>();

        products.add(new Product(1,"Sofa","Motion Sofa Chocolate"));
        products.add(new Product(2, "Bed", "Upholstered Diamond Stitched Platform Bed"));
        products.add(new Product(3, "Television", "50 inches 4K smart LED TV with AndroidOS"));
        products.add(new Product(4, "Video Game", "PlayBox 5One"));

        return products;
    }

}
