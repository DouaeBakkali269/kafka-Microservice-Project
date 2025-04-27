package com.example.notification_service.service;

import com.example.notification_service.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(Notification notification) {
        // Here you would implement actual notification sending logic
        // This could be email, SMS, push notification, etc.
        System.out.println("Sending notification: " + notification.getMessage() + 
                          " to user: " + notification.getUserId());
    }
}