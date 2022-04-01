package com.pichincha.practica.controller;

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

import com.pichincha.practica.dto.StoreDTO;
import com.pichincha.practica.exception.ApplicationException;
import com.pichincha.practica.service.StoreService;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

	@Autowired
	StoreService service;

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
	
	@GetMapping("/find/{name}")
	public ResponseEntity<Object> findById(@PathVariable String name) {
		try {
			return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody StoreDTO storeDTO) {
		try {
			return new ResponseEntity<>(service.save(storeDTO), HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ApplicationException(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
		try {
			return new ResponseEntity<>(service.update(id, storeDTO), HttpStatus.OK);
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
