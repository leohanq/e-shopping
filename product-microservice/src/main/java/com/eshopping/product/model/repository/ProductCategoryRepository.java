package com.eshopping.product.model.repository;

import com.eshopping.product.model.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {

    List<Product> findByCategoryId(@Param("id") Long id);
}
