package com.larry.paint_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.larry.paint_management_system.entity.OrderEvent;
import com.larry.paint_management_system.repository.OrderEventRepository;

@Service
public class OrderEventService {
    private OrderEventRepository orderEventRepository;

    public OrderEventService(OrderEventRepository orderEventRepository)
    {
        this.orderEventRepository = orderEventRepository;
    }

    public OrderEvent recordOrderEvent(String orderId, String eventType, String description){
        OrderEvent orderEvent = new OrderEvent(orderId, eventType, description);
        OrderEvent newOrderEvent = orderEventRepository.save(orderEvent);
        return newOrderEvent;
    }

    public List<OrderEvent> getOrderEventsByOrderId(String orderId)
    {
        return orderEventRepository.findByOrderId(orderId);
    }
}
