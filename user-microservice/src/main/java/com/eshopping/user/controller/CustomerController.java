package com.eshopping.user.controller;

import com.eshopping.user.controller.service.CustomerService;
import com.eshopping.user.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/users")
    public List<Customer> getCustomer() {
        return customerService.allCustomer();
    }

    @GetMapping("/users/{id}")
    public Customer getCustomer(@PathVariable(name = "id") Long id) {
        return customerService.getCustomer(id).orElseThrow();

    }

    @GetMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Customer customer) {
        customerService.deleteCustomer(customer);
    }
    @PostMapping("/users/save")
    public void saveUser(Customer customer) {
        customerService.saveCustomer(customer);
    }
}
