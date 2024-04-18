package com.eshopping.user.controller.service;


import com.eshopping.user.model.entity.Customer;
import com.eshopping.user.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Customer user) {
        customerRepository.delete(user);
    }

    public void saveCustomer(Customer user) {
        customerRepository.save(user);
    }



}
