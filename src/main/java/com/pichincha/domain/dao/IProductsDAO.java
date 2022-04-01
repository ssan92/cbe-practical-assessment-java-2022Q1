package com.pichincha.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.infraestructura.entity.Products;


@Repository
public interface IProductsDAO extends JpaRepository<Products,Integer>{
	
	@Query("SELECT u FROM Products u WHERE upper(u.name) = upper(?1) ")
	Products findProductByName(String name);
}
