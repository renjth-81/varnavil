package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer>{

}
