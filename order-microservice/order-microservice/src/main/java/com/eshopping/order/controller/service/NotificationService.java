package com.eshopping.order.controller.service;

import com.eshopping.order.model.dto.Email;

public interface NotificationService {

    void sendNotification(Email email);
}
