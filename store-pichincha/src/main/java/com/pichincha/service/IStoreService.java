package com.pichincha.service;

import java.util.List;

import com.pichincha.entity.Store;

public interface IStoreService {

	Store saveUpdateStore(Store store);

	void deleteStore(Long storeId);

	List<Store> getAllStores();

	Store getStoreById(Long storeId);
	
	Store findStoreByName(String name);
}
