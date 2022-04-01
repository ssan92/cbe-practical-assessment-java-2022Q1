package com.pichincha.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.entity.Store;
import com.pichincha.repo.IStoreRepo;
import com.pichincha.service.IStoreService;

@Service
public class StoreServiceImpl implements IStoreService {

	@Autowired
	private IStoreRepo storeRepo;

	@Override
	public Store saveUpdateStore(Store store) {
		return storeRepo.save(store);
	}

	@Override
	public void deleteStore(Long storeId) {
		Optional<Store> tiendaOpt = storeRepo.findById(storeId);
		if (tiendaOpt.isPresent()) {
			storeRepo.delete(tiendaOpt.get());
		}
	}

	@Override
	public List<Store> getAllStores() {
		return storeRepo.findAll();
	}

	@Override
	public Store getStoreById(Long storeId) {
		return storeRepo.findById(storeId).orElse(null);
	}

	@Override
	public Store findStoreByName(String name) {
		return storeRepo.findByName(name);
	}
}