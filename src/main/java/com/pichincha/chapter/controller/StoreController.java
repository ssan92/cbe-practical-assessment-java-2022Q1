package com.pichincha.chapter.controller;

import com.pichincha.chapter.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/assignProductsToStore/{codStore}")
    public ResponseEntity assignProductsToStore(@PathVariable("codStore") Long codStore) {
        log.info("codStore: " + codStore);
        storeService.assignProductsToStore(codStore);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
