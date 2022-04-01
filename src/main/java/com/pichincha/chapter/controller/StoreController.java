package com.pichincha.chapter.controller;

import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/saveStore")
    public ResponseEntity saveStore(@RequestBody Store store) {
        Store storeSaved = storeService.saveStore(store);
        return new ResponseEntity(storeSaved, HttpStatus.CREATED);
    }
}
