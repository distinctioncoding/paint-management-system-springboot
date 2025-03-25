package com.larry.paint_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larry.paint_management_system.dto.OrderDto;
import com.larry.paint_management_system.entity.Order;
import com.larry.paint_management_system.service.OrderService;


@RestController
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) throws Exception
    {
        Order order = orderService.creatOrder(orderDto);
        return ResponseEntity.ok(order);
    }
}
