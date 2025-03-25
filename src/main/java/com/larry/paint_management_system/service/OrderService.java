package com.larry.paint_management_system.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.larry.paint_management_system.dto.OrderDto;
import com.larry.paint_management_system.entity.Order;
import com.larry.paint_management_system.entity.OrderStatus;
import com.larry.paint_management_system.entity.User;
import com.larry.paint_management_system.repository.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderEventService orderEventService;
    private UserService userService;

    public OrderService(OrderRepository orderRepository, OrderEventService orderEventService, UserService userService)
    {
        this.orderEventService = orderEventService;
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Order creatOrder(OrderDto orderDto) throws Exception
    {
        Optional<User> user = userService.getUserByUserId(orderDto.getUserId());
        if (user == null)
        {
            throw new Exception("User not found for: " + orderDto.getUserId());
        }
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order(user.get(), now, OrderStatus.CONFIRMED);
        Order newOrder = orderRepository.save(order);
        orderEventService.recordOrderEvent(newOrder.getId().toString(), "ORDER_CREATED", "ORDER_CREATED");
        return newOrder;
    }
}
