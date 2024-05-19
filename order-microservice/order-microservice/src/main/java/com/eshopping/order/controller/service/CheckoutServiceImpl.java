package com.eshopping.order.controller.service;


import com.eshopping.order.client.UserFeignClient;
import com.eshopping.order.model.dto.Purchase;
import com.eshopping.order.model.dto.PurchaseResponse;
import com.eshopping.order.model.entity.Customer;
import com.eshopping.order.model.entity.Order;
import com.eshopping.order.model.entity.OrderItem;
import com.eshopping.order.model.respository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private OrderRepository orderRepository;

    private UserFeignClient userClient;

    public CheckoutServiceImpl(OrderRepository orderRepository, UserFeignClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.order();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.orderItems();
        orderItems.forEach(order::add);

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.billingAddress());
        // order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.customer();
        Optional<Customer> customerOptional = Optional.ofNullable(userClient.getCustomerByEmail(customer.getFirstName(), customer.getEmail()));
        customerOptional.ifPresentOrElse(
                order::setCustomer,
                () -> {
                    Customer customerToSave = userClient.saveCustomer(customer);
                    order.setCustomer(customerToSave);
                }
        );
        // save to the database
        orderRepository.save(order);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









