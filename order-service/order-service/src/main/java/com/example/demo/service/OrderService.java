package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Order createOrder(Order order) {
        // Set order ID and initial status
        order.setId(UUID.randomUUID().toString());
        order.setStatus("PENDING");

        // Publish order created event
        kafkaTemplate.send("order.created", order);

        return order;
    }
}