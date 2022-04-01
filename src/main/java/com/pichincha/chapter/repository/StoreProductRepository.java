package com.pichincha.chapter.repository;

import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.domain.jpa.StoreProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepository extends CrudRepository<StoreProduct, Long> {

    List<StoreProduct> findByStore(Store store);
}
