package com.pichincha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pichincha.entity.Store;
import com.pichincha.entity.StoreProduct;

public interface IStoreProductRepo extends JpaRepository<StoreProduct, Long> {
	List<StoreProduct> findByStore(Store tienda);

	@Query("from StoreProduct sp where sp.store.id=:storeId and sp.product.id=:productId")
	StoreProduct findByStoreIdAndProductId(@Param("storeId") Long storeId, @Param("productId") Long productId);
}
