package com.pichincha.domain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.infraestructura.entity.ShopsByProducts;
import com.pichincha.infraestructura.entity.ShopsByProductsCPK;


@Repository
public interface IShopsByProductsDAO extends JpaRepository<ShopsByProducts,ShopsByProductsCPK>{
	
	@Query("SELECT u FROM ShopsByProducts u WHERE u.shopsByProductsCPK.idShop=?1 ")
	List<ShopsByProducts> findShopsByProductsByShops(Integer code);
}
