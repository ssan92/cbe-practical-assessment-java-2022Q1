package com.miguelmejia.q12022.repository;

import com.miguelmejia.q12022.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(String name);
}
