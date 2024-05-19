package com.eshopping.order.controller.service;


import com.eshopping.order.model.dto.Purchase;
import com.eshopping.order.model.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
