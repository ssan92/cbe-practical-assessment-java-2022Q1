package com.pichincha.evaluacion.practica.repository;

import com.pichincha.evaluacion.practica.entity.ProductXUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductXUserRepository extends JpaRepository<ProductXUserEntity, Long> {
}
