package com.eshopping.user.model.repository;

import com.eshopping.user.model.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {

}
