package com.example.notification_service.listener;

import com.example.notification_service.dto.PaymentEvent;
import com.example.notification_service.model.Notification;
import com.example.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "payment.processed", groupId = "notification-group")
    public void handlePaymentProcessed(PaymentEvent paymentEvent) {
        Notification notification = new Notification(
            paymentEvent.getUserId(),  // Now using the correct userId
            "Payment processed successfully for order: " + paymentEvent.getOrderId(),
            "PAYMENT_CONFIRMATION"
        );
        notificationService.sendNotification(notification);
    }
}