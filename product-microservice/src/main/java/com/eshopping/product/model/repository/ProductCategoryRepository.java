package com.eshopping.product.model.repository;

import com.eshopping.product.model.entity.ProductCategory;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductCategoryRepository extends ListCrudRepository<ProductCategory, Integer> {

}
