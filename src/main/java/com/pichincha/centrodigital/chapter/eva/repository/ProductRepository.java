package com.pichincha.centrodigital.chapter.eva.repository;

import com.pichincha.centrodigital.chapter.eva.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}