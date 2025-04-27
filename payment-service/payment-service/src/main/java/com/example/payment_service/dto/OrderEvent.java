package com.example.payment_service.dto;

import java.math.BigDecimal;

public class OrderEvent {
    private String orderId;
    private BigDecimal amount;
    
    // Only include fields that Payment service needs
    public OrderEvent() {}
    
    public OrderEvent(String orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
    
    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}