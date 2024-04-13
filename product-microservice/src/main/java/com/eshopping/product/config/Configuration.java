package com.eshopping.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${user.service.url}")
    private String userUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(userUrl).build();
    }
}
