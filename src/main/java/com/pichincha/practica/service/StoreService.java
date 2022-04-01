package com.pichincha.practica.service;

import java.util.Optional;

import com.pichincha.practica.dto.StoreDTO;
import com.pichincha.practica.exception.ApplicationException;

public interface StoreService extends CRUD<StoreDTO, Long> {

	Optional<StoreDTO> findByName(String name) throws ApplicationException;
}
