package com.larry.paint_management_system.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "order_events")
@Getter
@Setter
public class OrderEvent {
    
    @Id
    private String id;

    private String orderId;
    private String eventType;
    private LocalDateTime timestamp;
    private String description;

    public OrderEvent(){}

    public OrderEvent(String orderId, String eventType, String description)
    {
        this.orderId = orderId;
        this.eventType = eventType;
        this.description = description;
    }
}
