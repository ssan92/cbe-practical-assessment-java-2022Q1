package com.pichincha.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pichincha.infraestructura.Users;

public interface IUsersDAO extends JpaRepository<Users, String>{
	
	@Query("SELECT u FROM Users u WHERE upper(u.user) = upper(?1) ")
	Users findUsersByUser(String strUser);
}
