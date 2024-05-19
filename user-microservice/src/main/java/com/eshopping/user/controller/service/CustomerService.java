package com.eshopping.user.controller.service;


import com.eshopping.user.model.entity.Customer;
import com.eshopping.user.model.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Customer getCustomerByEmail(String name, String email) {
        return customerRepository.findCustomerByFirstNameAndEmail(name, email);
    }

    public void deleteCustomer(Customer user) {
        customerRepository.delete(user);
    }

    public Customer saveCustomer(Customer user) {
        return customerRepository.save(user);
    }



}
