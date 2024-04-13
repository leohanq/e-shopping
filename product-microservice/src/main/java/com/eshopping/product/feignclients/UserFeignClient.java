package com.eshopping.product.feignclients;

import com.eshopping.product.model.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${user.service.url}", name="user-service")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") Integer id);
}
