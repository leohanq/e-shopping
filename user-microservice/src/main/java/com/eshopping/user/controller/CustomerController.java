package com.eshopping.user.controller;

import com.eshopping.user.controller.service.CustomerService;
import com.eshopping.user.model.entity.Customer;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
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

    @GetMapping("/users/findCustomerByNameAndEmail")
    public Customer getCustomer(@QueryParam("firstName") String firstName, @QueryParam("email") String email) {
        return customerService.getCustomerByEmail(firstName, email);
    }

    @GetMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Customer customer) {
        customerService.deleteCustomer(customer);
    }
    @PostMapping("/users/save")
    public Customer saveUser(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
