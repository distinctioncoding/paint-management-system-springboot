package com.larry.paint_management_system.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.larry.paint_management_system.entity.OrderEvent;

@Repository
public interface OrderEventRepository extends MongoRepository<OrderEvent, String> {
    List<OrderEvent> findByOrderId(String orderId);
}
