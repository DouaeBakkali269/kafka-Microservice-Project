package com.example.notification_service.model;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private String userId;
    private String message;
    private String type;
    private LocalDateTime createdAt;

    // Constructors
    public Notification() {}

    public Notification(String userId, String message, String type) {
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}