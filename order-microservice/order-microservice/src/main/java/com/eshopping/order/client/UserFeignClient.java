package com.eshopping.order.client;

import com.eshopping.order.model.entity.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name= "${dependencies.user.url}", path = "/eshopping")
public interface UserFeignClient {

    @GetMapping("users/findCustomerByNameAndEmail")
    Customer getCustomerByEmail(@RequestParam("firstName") String name, @RequestParam("email") String email);
    @PostMapping("/users/save")
    Customer saveCustomer(Customer customer);

    @GetMapping("/users")
    List<Customer> getUsers();
}
