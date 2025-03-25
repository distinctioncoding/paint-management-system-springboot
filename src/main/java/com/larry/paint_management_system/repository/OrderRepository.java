package com.larry.paint_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larry.paint_management_system.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByUserId(Long userId);
}
