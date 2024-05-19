package com.eshopping.product.controller;


import com.eshopping.product.controller.service.ProductService;
import com.eshopping.product.model.entity.Product;
import com.eshopping.product.model.entity.ProductCategory;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @CrossOrigin("http://localhost:4200")
    public List<Product> getProducts() {
        return productService.allProduct();
    }

    @GetMapping("/product/{id}")
    @CrossOrigin("http://localhost:4200")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @GetMapping("/products/search/findByCategoryId")
    @CrossOrigin("http://localhost:4200")
    public List<Product> getProduct(@QueryParam("id") Long id) {
        return productService.searchCategoryById(id);
    }

    @GetMapping("/product-category")
    @CrossOrigin("http://localhost:4200")
    public List<ProductCategory> getProductCategories() {
        return productService.allProductCategories();
    }
}
