package com.pichincha.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.entity.Product;
import com.pichincha.entity.Store;
import com.pichincha.entity.StoreProduct;
import com.pichincha.repo.IStoreProductRepo;
import com.pichincha.repo.IStoreRepo;
import com.pichincha.service.IStoreProductService;

@Service
public class StoreProductServiceImpl implements IStoreProductService {

	@Autowired
	private IStoreProductRepo storeProductRepo;
	@Autowired
	private IStoreRepo storeRepo;

	@Override
	public StoreProduct saveUpdate(StoreProduct storeProduct) {
		return storeProductRepo.save(storeProduct);
	}

	@Override
	public List<Product> getProductsByStoreId(long storeId) {
		Optional<Store> storeOpt = storeRepo.findById(storeId);
		List<Product> products = new ArrayList<>();
		if (storeOpt.isPresent()) {
			List<StoreProduct> tiendaProducts = storeProductRepo.findByStore(storeOpt.get());
			tiendaProducts.forEach(tiendaProd -> products.add(tiendaProd.getProduct()));
		}
		return products;
	}

	@Override
	public StoreProduct findByStoreIdAndStoreProductId(long storeId, long storeProductId) {
		return storeProductRepo.findByStoreIdAndProductId(storeId, storeProductId);
	}

	@Override
	public List<StoreProduct> saveList(List<StoreProduct> products) {
		return storeProductRepo.saveAll(products);
	}
}