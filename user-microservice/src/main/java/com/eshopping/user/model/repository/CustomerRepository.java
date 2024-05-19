package com.eshopping.user.model.repository;

import com.eshopping.user.model.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {

    Customer findCustomerByFirstNameAndEmail(@Param("firstName") String firstName, @Param("email") String email);
}
