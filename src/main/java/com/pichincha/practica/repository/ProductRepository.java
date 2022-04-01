package com.pichincha.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.practica.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
