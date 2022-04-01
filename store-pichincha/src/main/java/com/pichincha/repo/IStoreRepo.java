package com.pichincha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.entity.Store;

public interface IStoreRepo extends JpaRepository<Store, Long> {
	Store findByName(String name);
}
