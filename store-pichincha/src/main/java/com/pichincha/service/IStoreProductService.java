package com.pichincha.service;

import java.util.List;

import com.pichincha.entity.Product;
import com.pichincha.entity.StoreProduct;

public interface IStoreProductService {

	StoreProduct saveUpdate(StoreProduct storeProduct);

	List<Product> getProductsByStoreId(long storeId);

	StoreProduct findByStoreIdAndStoreProductId(long storeId, long storeProductId);

	List<StoreProduct> saveList(List<StoreProduct> storeProducts);
}