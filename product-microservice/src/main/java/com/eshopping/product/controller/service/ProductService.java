package com.eshopping.product.controller.service;


import com.eshopping.product.feignclients.UserFeignClient;
import com.eshopping.product.model.dto.User;
import com.eshopping.product.model.entity.Product;
import com.eshopping.product.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebClient webClient;

    @Autowired
    private UserFeignClient userFeignClient;

    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }


    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public User getUserById(Integer userId) {
        return userFeignClient.getUser(userId);
      //  Mono<User> userMono = webClient.get().uri("/users/%s".formatted(userId))
        //        .retrieve().bodyToMono(User.class);
        //return userMono.block();
    }
}
