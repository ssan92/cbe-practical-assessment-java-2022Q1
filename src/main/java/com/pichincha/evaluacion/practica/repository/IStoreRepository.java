package com.pichincha.evaluacion.practica.repository;

import com.pichincha.evaluacion.practica.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<StoreEntity, Long> {
}
