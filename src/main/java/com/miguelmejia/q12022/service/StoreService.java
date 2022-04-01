package com.miguelmejia.q12022.service;

import com.miguelmejia.q12022.presenter.StorePresenter;

public interface StoreService {
    void save(StorePresenter storePresenter);

    StorePresenter findByName(String name);

    void update(StorePresenter storePresenter);
}
