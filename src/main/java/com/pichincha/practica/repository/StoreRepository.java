package com.pichincha.practica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.practica.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	Optional<Store> findByName(String name);
}
