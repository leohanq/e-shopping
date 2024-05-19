package com.eshopping.product.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "${user.service.url}", name="user-service")
public interface UserFeignClient {

}
