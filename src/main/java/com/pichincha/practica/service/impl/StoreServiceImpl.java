package com.pichincha.practica.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.practica.dto.StoreDTO;
import com.pichincha.practica.exception.ApplicationException;
import com.pichincha.practica.model.Store;
import com.pichincha.practica.repository.StoreRepository;
import com.pichincha.practica.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository repo;

	@Override
	public StoreDTO save(StoreDTO store) throws ApplicationException {
		return repo.save(store.toEntity()).toDTO();
	}

	@Override
	public StoreDTO update(Long id, StoreDTO store) throws ApplicationException {
		Optional<StoreDTO> data = findById(id);
		if (data.isPresent()) {
			Store objStore = store.toEntity();
			objStore.setCategory(store.getCategory());
			objStore.setId(id);
			objStore.setOwnerId(store.getOwnerId());
			objStore.setName(store.getName());
			objStore.setCreationDate(data.get().getCreationDate());
			return repo.save(objStore).toDTO();
		} else {
			throw new ApplicationException("Not exists");
		}
	}

	@Override
	public List<StoreDTO> findAll() {
		List<Store> stores = repo.findAll();		
		return stores.stream().map(c -> c.toDTO()).collect(Collectors.toList());
	}

	@Override
	public Optional<StoreDTO> findById(Long id) throws ApplicationException {
		Optional<Store>  store = repo.findById(id);
		Optional<StoreDTO> storeDTO = Optional.empty();
		if(store.isPresent()) {			
			storeDTO =  Optional.of(store.get().toDTO());
		}
		return storeDTO;
	}
	
	@Override
	public Optional<StoreDTO> findByName(String name) throws ApplicationException {
		Optional<Store>  store = repo.findByName(name);
		Optional<StoreDTO> storeDTO = Optional.empty();
		if(store.isPresent()) {			
			storeDTO =  Optional.of(store.get().toDTO());
		}
		return storeDTO;
	}

	@Override
	public void delete(Long id) throws ApplicationException {
		Optional<StoreDTO> data = findById(id);
		if (data.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new ApplicationException("Not exists");
		}
		
	}

}