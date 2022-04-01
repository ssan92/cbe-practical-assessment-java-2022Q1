package com.pichincha.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.infraestructura.Users;

public interface IUsersDAO extends JpaRepository<Users, String>{

}
