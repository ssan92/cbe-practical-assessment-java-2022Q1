package com.miguelmejia.q12022.controller;

import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/store")
    public void createStore(@RequestBody StorePresenter storePresenter) {
        storeService.save(storePresenter);
    }
}
