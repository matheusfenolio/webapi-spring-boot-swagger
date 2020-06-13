package com.api.api.controller;

import com.api.api.Mock.MockProduct;
import com.api.api.model.Product;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    private void setup(){
        productController.products.clear();
    }

    @Test
    public void testInsertAndGetSpecific() throws Exception{
        productController.insertProduct(MockProduct.getProductXTUDO());
        Product product = productController.getSpecificProducts(1);
        assertEquals(product.getName(), MockProduct.getProductXTUDO().getName());
    }

    @Test
    public void testUpdate() throws Exception{
        /*Insert to do an update*/
        productController.insertProduct(MockProduct.getProductXTUDO());
        Product product = productController.getSpecificProducts(1);
        assertEquals(product.getName(), MockProduct.getProductXTUDO().getName());

        /*Do update*/
        productController.updateProduct(MockProduct.getProductXTUDOUpdate());
        product = productController.getSpecificProducts(1);
        assertEquals(product.getDescription(), MockProduct.getProductXTUDOUpdate().getDescription());
    }

    @Test
    public void testDeleteAndGetAll() throws Exception{
        /*Insert to do a delete*/
        productController.insertProduct(MockProduct.getProductXTUDO());
        productController.insertProduct(MockProduct.getProductXBURGUER());

        assertEquals(productController.getAllProducts().size(), 2);

        /*Do delete*/
        productController.deleteProduct(1);
        assertEquals(productController.getAllProducts().size(), 1);
    }

    @Test
    public void testEqualsAndHashcode(){
        EqualsVerifier.forClass(Product.class)
                .usingGetClass()
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

}
