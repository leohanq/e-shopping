package com.eshopping.product.controller.service;


import com.eshopping.product.model.entity.Product;
import com.eshopping.product.model.entity.ProductCategory;
import com.eshopping.product.model.repository.ProductCategoryRepository;
import com.eshopping.product.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    public List<Product> searchCategoryById(Long id){
        return productRepository.findByCategoryId(id);
    }

    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }


    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<ProductCategory> allProductCategories() {
        return productCategoryRepository.findAll();
    }
}
