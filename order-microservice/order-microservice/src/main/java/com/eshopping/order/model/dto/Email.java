package com.eshopping.order.model.dto;

import java.util.List;

public record Email(String subject, String sender, List<String> recipients,
                    String password, String email, String message) {
}
