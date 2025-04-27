package com.example.payment_service.service;

import com.example.payment_service.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Payment processPayment(Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        // Simulate payment processing
        payment.setStatus("COMPLETED");
        
        // Publish payment processed event
        kafkaTemplate.send("payment.processed", payment);
        
        return payment;
    }
}