package com.pichincha.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.infraestructura.Shops;


@Repository
public interface IShopsDAO extends JpaRepository<Shops,Integer>{
	
	@Query("SELECT u FROM Shops u WHERE upper(u.name) = upper(?1) ")
	Shops findShopByName(String name);
}
