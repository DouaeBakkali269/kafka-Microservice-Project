package com.example.payment_service.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    /**
     * ConsumerFactory Bean Configuration
     * 
     * This bean configures how Kafka consumers will be created in the application.
     * It sets up essential properties for Kafka consumer operation:
     * 
     * 1. BOOTSTRAP_SERVERS_CONFIG: Defines the Kafka broker location (localhost:9092)
     * 2. GROUP_ID_CONFIG: Sets consumer group for load balancing and fault tolerance
     * 3. KEY_DESERIALIZER_CLASS_CONFIG: Converts message keys from byte[] to String
     * 4. VALUE_DESERIALIZER_CLASS_CONFIG: Converts message values from byte[] to JSON
     * 5. TRUSTED_PACKAGES: Security setting for deserialization ("*" allows all packages)
     * 
     * Note: In production, consider restricting TRUSTED_PACKAGES to specific package names
     * for better security.
     */
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "payment-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(config);
    }

    /**
     * KafkaListenerContainerFactory Bean Configuration
     * 
     * This factory creates containers that manage Kafka message listeners.
     * Key responsibilities:
     * 
     * 1. Creates and manages concurrent Kafka listener containers
     * 2. Utilizes the ConsumerFactory bean for creating consumer instances
     * 3. Enables parallel processing of Kafka messages
     * 4. Handles message consumption and error scenarios
     * 5. Manages the lifecycle of message listeners
     * 
     * This factory is crucial for @KafkaListener annotations to work properly
     * in the application's consumer classes.
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}