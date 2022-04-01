package com.pichincha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.entity.Product;

public interface IProductRepo extends JpaRepository<Product, Long> {

	Product findByCod(String cod);
}
