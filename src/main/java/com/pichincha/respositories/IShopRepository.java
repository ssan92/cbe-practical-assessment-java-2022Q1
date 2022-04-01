package com.pichincha.respositories;

import com.pichincha.domains.jpa.ShopJpa;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends CrudRepository<ShopJpa, String> {

  Optional<ShopJpa> getShopJpaById(String id);
}
