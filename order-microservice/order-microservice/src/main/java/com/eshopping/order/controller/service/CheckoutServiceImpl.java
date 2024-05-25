package com.eshopping.order.controller.service;


import com.eshopping.order.client.UserFeignClient;
import com.eshopping.order.model.dto.Email;
import com.eshopping.order.model.dto.Purchase;
import com.eshopping.order.model.dto.PurchaseResponse;
import com.eshopping.order.model.entity.Customer;
import com.eshopping.order.model.entity.Order;
import com.eshopping.order.model.entity.OrderItem;
import com.eshopping.order.model.respository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private OrderRepository orderRepository;

    private UserFeignClient userClient;

    private NotificationService notificationService;

    public CheckoutServiceImpl(OrderRepository orderRepository, UserFeignClient userClient, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.notificationService = notificationService;
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

        Email email = buildEmail(order, orderTrackingNumber);

        notificationService.sendNotification(email);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private Email buildEmail(Order order, String orderTrackingNumber) {
        Customer customer = order.getCustomer();
        List<String> recipients = List.of(customer.getEmail());
        String message = """
                Dear [%s],
                Thank you for shopping with us!
                We are pleased to confirm that your order has been received
                and is being processed. Below are the details of your order:
                
                Order Number: [%s]
                Order Date: [%s]
                
                Order Summary:
                
                Items: [TODO]
                Quantity: [%s]
                Total: [%s]
                
                Thank you for your purchase!
                Best regards
                """.formatted(customer.getFirstName(), orderTrackingNumber, LocalDate.now(),
                order.getTotalQuantity(), order.getTotalPrice());
        return new Email("Purchase Order",
                "lq1930@gmail.com", recipients,
                "wben rxok npkx qrgv",
                "lq1930@gmail.com",
                message);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}









