package com.pichincha.practica.service;

import java.util.List;

import com.pichincha.practica.dto.ProductDTO;
import com.pichincha.practica.exception.ApplicationException;

public interface ProductService extends CRUD<ProductDTO, Long> {

	boolean saveByList(Long storeId, List<ProductDTO> products) throws ApplicationException;
}
