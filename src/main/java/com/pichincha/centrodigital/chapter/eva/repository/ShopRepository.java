package com.pichincha.centrodigital.chapter.eva.repository;

import com.pichincha.centrodigital.chapter.eva.entity.ShopEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {

  Optional<ShopEntity> findByName(String name);
}