package com.pichincha.store.controller;

import com.pichincha.store.domain.dto.StoreDto;
import com.pichincha.store.service.StoreService;
import javax.ws.rs.Consumes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {

  private final StoreService storeService;

  @PostMapping("/")
  @Consumes("application/json")
  public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto info) {

    return ResponseEntity.status(HttpStatus.OK).body(storeService.createStore(info));
  }

  @GetMapping("/{name}")
  @Consumes("application/json")
  public ResponseEntity<StoreDto> getStoreByName(@PathVariable String name) {
    return ResponseEntity.status(HttpStatus.OK).body(storeService.getStoreByName(name));
  }

  @PutMapping("/")
  @Consumes("application/json")
  public ResponseEntity<String> updteStore(@RequestBody StoreDto info) {
    return ResponseEntity.status(HttpStatus.OK).body(storeService.updateStore(info));
  }

  @DeleteMapping("/{id}")
  @Consumes("application/json")
  public ResponseEntity<String> getStoreByName(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(storeService.deleteStoreWithNoProducts(id));
  }

  @PutMapping("/product/{storeId}")
  @Consumes("application/json")
  public ResponseEntity<String> loadProducts(@PathVariable Long storeId) {
    return ResponseEntity.status(HttpStatus.OK).body(storeService.loadProducts(storeId));
  }

}
