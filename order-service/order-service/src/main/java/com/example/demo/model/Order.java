package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private String id;
    private String userId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;

    // Constructors
    public Order() {}

    public Order(String userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
