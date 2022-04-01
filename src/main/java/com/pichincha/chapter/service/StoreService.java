package com.pichincha.chapter.service;

import com.pichincha.chapter.domain.dto.store.response.StoreProductDetailTo;
import com.pichincha.chapter.domain.jpa.Store;

public interface StoreService {

    Store saveStore(Store store);

    Store getStoreByName(String name);

    Store updateStore(Store store);

    void deleteStoreWithoutProducts(Long codStore);

    StoreProductDetailTo assignProductsToStore(Long codStore);
}
