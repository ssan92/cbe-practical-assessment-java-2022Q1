package com.pichincha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pichincha.entity.ProductStoreOrder;

public interface IProductStoreOrderRepo extends JpaRepository<ProductStoreOrder, Long> {

	@Query("from ProductStoreOrder pp where pp.order.id=:orderId and pp.product.id=:productId and pp.store.id=:storeId")
	ProductStoreOrder findByOrderIdAndStoreIdAndProductId(@Param("orderId") Long orderId,
			@Param("storeId") Long storeId, @Param("productId") Long productId);

	@Query("from ProductStoreOrder pp where pp.order.id=:orderId")
	List<ProductStoreOrder> getByOrderId(@Param("orderId") Long orderId);
}
