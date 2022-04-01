package com.miguelmejia.q12022.service;

import com.miguelmejia.q12022.presenter.ProductPresenter;

import java.util.List;

public interface ProductService {
    void generateStock(Long id);

    List<ProductPresenter> findAll();

    List<ProductPresenter> findAllByStore(Long storeId);
}
