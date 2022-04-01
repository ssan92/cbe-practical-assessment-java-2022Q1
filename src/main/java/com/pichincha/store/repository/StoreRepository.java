
package com.pichincha.store.repository;


import com.pichincha.store.domain.Store;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends CrudRepository<Store, Long> {

  @Query(value = "select s from Store s where s.name = :name and s.status = :status")
  Optional<Store> getStoreByName(@Param("name")String name, @Param("status") String status);


  @Query(value = "select s from Store s where s.id = :id and s.status = :status")
  Optional<Store> getStoreById(@Param("id") Long id,@Param("status") String status);


}
