package com.pichincha.respositories;

import com.pichincha.domains.jpa.ShopUserJpa;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopUserRepository extends CrudRepository<ShopUserJpa, String> {

  Optional<ShopUserJpa> getShopUserJpaByIdentification(String identification);
}
