package com.pichincha.chapter.repository;

import com.pichincha.chapter.domain.jpa.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
}
