# E-Commerce Microservices with Kafka

This project demonstrates a microservices architecture using Spring Boot and Apache Kafka for event-driven communication between services.

## Architecture Overview

```mermaid
graph LR
    Client[Client] --> OrderService[Order Service]
    OrderService --> |order.created| Kafka{Kafka}
    Kafka --> |order.created| PaymentService[Payment Service]
    PaymentService --> |payment.processed| Kafka
    Kafka --> |payment.processed| NotificationService[Notification Service]
    NotificationService --> |Sends Email/SMS| User((User))
 ```   
 ## Service Descriptions
### Order Service
- Creates and manages orders
- Publishes order.created events to Kafka
- Listens for payment.processed events to update order status
### Payment Service
- Processes payments for orders
- Consumes order.created events
- Publishes payment.processed events
### Notification Service
- Handles customer notifications
- Consumes payment.processed events
- Sends notifications via email/SMS
## Kafka Topics
1. order.created - New order events
2. payment.processed - Payment status events
## Project Structure
```plaintext
kafka-practice/
├── order-service/
├── payment-service/
├── notification-service/
└── docker-compose.yml
 ```