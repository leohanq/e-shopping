package com.eshopping.order.model.dto;

import com.eshopping.order.model.entity.Customer;
import com.eshopping.order.model.entity.Order;
import com.eshopping.order.model.entity.OrderItem;

import java.util.Set;

public record Purchase(Customer customer, String billingAddress, Order order,
                       Set<OrderItem> orderItems) {
}
