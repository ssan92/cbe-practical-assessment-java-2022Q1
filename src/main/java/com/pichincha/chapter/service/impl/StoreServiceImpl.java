package com.pichincha.chapter.service.impl;

import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.exception.StoreAdministrationException;
import com.pichincha.chapter.repository.StoreRepository;
import com.pichincha.chapter.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreByName(String name) {
        return storeRepository.findByName(name).stream().findFirst()
                .orElseThrow(() -> new StoreAdministrationException("Store not founded."));
    }

    @Override
    public Store updateStore(Store store) {
        Optional<Store> storeOptional = storeRepository.findById(store.getCod());
        if (storeOptional.isPresent()) {
            storeOptional.get().setCategory(store.getCategory());
            storeOptional.get().setName(store.getName());
            storeOptional.get().setOwner(store.getOwner());
            return storeOptional.get();
        } else {
            throw new StoreAdministrationException("Store not founded.");
        }
    }

    @Override
    public void deleteStoreWithoutProducts(Long codStore) {

    }


}
