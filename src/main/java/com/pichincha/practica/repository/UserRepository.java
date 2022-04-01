package com.pichincha.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.practica.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
