package com.example.notification_service.dto;

public class PaymentEvent {
    private String orderId;
    private String userId;  // Add userId
    private String status;
    
    // Constructor
    public PaymentEvent() {}
    
    public PaymentEvent(String orderId, String userId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
    }
    
    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}