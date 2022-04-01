package com.pichincha.practica.service;

import java.util.List;
import java.util.Optional;

import com.pichincha.practica.exception.ApplicationException;

public interface CRUD<T, ID> {

	public T save(T pac) throws ApplicationException;

	public T update(ID id, T pac) throws ApplicationException;

	public List<T> findAll();

	public Optional<T> findById(ID id) throws ApplicationException;

	public void delete(ID id) throws ApplicationException;
}
