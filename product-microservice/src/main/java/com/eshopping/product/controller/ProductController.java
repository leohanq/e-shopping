package com.eshopping.product.controller;


import com.eshopping.product.controller.service.ProductService;
import com.eshopping.product.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @CrossOrigin("http://localhost:4200")
    public List<Product> getProducts() {
        return productService.allProduct();
        //User user = productService.getUserById(1);
        //System.out.println(user);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }
}
