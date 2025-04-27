package com.example.payment_service.listener;

import com.example.payment_service.dto.OrderEvent;
import com.example.payment_service.model.Payment;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "order.created", groupId = "payment-group")
    public void handleOrderCreated(OrderEvent orderEvent) {
        Payment payment = new Payment(orderEvent.getOrderId(), orderEvent.getAmount());
        paymentService.processPayment(payment);
    }
}