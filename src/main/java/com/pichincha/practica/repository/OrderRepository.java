package com.pichincha.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.practica.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
