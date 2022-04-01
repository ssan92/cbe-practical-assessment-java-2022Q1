package com.pichincha.chapter.service.impl;

import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.repository.StoreRepository;
import com.pichincha.chapter.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }
}
