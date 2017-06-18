package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VOrder;

public interface VOrderRepository extends JpaRepository<VOrder,Integer>{

}
