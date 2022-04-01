package com.miguelmejia.q12022.controller;

import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/store")
    public void createStore(@RequestBody StorePresenter storePresenter) {
        storeService.save(storePresenter);
    }

    @GetMapping("/store/name")
    public StorePresenter findByName(@RequestParam String name) {
        return storeService.findByName(name);
    }

    @PutMapping("/store")
    public void updateStore(@RequestBody StorePresenter storePresenter) {
        storeService.update(storePresenter);
    }
}
