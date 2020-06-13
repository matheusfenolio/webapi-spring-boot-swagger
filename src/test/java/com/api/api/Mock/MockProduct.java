package com.api.api.Mock;

import com.api.api.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MockProduct {

    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"X-TUDO","Pao de hamburguer, queijo, tomate, bacon, ovo, hamburguer de carne bovina"));
        products.add(new Product(2, "X-BURGUER", "Pao de hamburguer, queijo, hamburguer de carne bovina"));

        return products;
    }

    public static Product getProductXTUDO(){
        return new Product.Builder().id(1).name("X-TUDO").description("Pao de hamburguer, queijo, tomate, bacon, ovo, hamburguer de carne bovina").build();
    }

    public static Product getProductXTUDOUpdate(){
        return new Product.Builder().id(1).name("X-TUDO").description("Pão de hamburguer, queijo, tomate, bacon, ovo, hamburguer de carne bovina").build();
    }

    public static Product getProductXBURGUER(){
        return new Product.Builder().id(2).name("X-BURGUER").description("Pão de hamburguer, queijo, hamburguer de carne bovina").build();
    }

}
