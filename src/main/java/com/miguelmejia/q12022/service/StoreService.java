package com.miguelmejia.q12022.service;

import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.presenter.StorePresenter;

import java.util.List;

public interface StoreService {
    void save(StorePresenter storePresenter);

    StorePresenter findByName(String name);

    Store findById(Long id);

    void update(StorePresenter storePresenter);

    void deleteEmptyStore(Long id);

    List<StorePresenter> findAll();
}
