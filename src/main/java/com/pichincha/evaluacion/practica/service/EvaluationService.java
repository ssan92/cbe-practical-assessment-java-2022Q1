package com.pichincha.evaluacion.practica.service;

import com.pichincha.evaluacion.practica.entity.StoreEntity;
import com.pichincha.evaluacion.practica.repository.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private IStoreRepository storeRepository;

    public List<StoreEntity> getStoresList() {
        return storeRepository.findAll();
    }

    public List<StoreEntity> getStoreById(long id) {
        return storeRepository.findAllById(Collections.singleton(id));
    }

    public int saveStore(StoreEntity storeEntity) {
        int res = 0;
        StoreEntity save = storeRepository.save(storeEntity);
        if (!save.equals(null)) {
            res = 1;
        }
        return res;
    }

    public int updateClient(StoreEntity store, long id) {
        var response = getStoreById(id);
        System.out.println(response);
        store.setId(id);
        return saveStore(store);
    }

    public int deleteClient(long id) {
        int res = 0;
        storeRepository.deleteById(id);
        if (!storeRepository.equals(null)) {
            res = 1;
        }
        return res;
    }
}
