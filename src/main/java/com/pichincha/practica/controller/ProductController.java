package com.pichincha.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.practica.dto.ProductDTO;
import com.pichincha.practica.exception.ApplicationException;
import com.pichincha.practica.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody ProductDTO productDTO) {
		try {
			return new ResponseEntity<>(service.save(productDTO), HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{storeId}")
	public ResponseEntity<Object> saveByList(@PathVariable Long storeId, @RequestBody List<ProductDTO> products) {
		try {
			return new ResponseEntity<>(service.saveByList(storeId, products), HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody ProductDTO productDTO) {
		try {
			return new ResponseEntity<>(service.update(id, productDTO), HttpStatus.OK);
		} catch (ApplicationException ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (ApplicationException ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

}
