package com.pichincha.centrodigital.chapter.eva.repository;

import com.pichincha.centrodigital.chapter.eva.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}