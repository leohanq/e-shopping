package com.eshopping.product.model.repository;

import com.eshopping.product.model.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {


}
