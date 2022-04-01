package com.pichincha.store.service;

import com.pichincha.store.domain.dto.StoreDto;

public interface StoreService {

  StoreDto createStore(StoreDto newStore);
  StoreDto getStoreByName(String storeName);
  String updateStore(StoreDto storeDto);
  String deleteStoreWithNoProducts(Long storeId);
  String loadProducts(Long storeId);

}
