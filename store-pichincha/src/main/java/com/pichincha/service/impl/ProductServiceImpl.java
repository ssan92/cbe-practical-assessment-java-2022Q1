package com.pichincha.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.entity.Product;
import com.pichincha.repo.IProductRepo;
import com.pichincha.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepo productoRepo;

	@Override
	public Product saveUpdate(Product producto) {
		return productoRepo.save(producto);
	}

	@Override
	public void delete(Long idProduct) {
		Optional<Product> productoOpt = productoRepo.findById(idProduct);
		if (productoOpt.isPresent()) {
			productoRepo.delete(productoOpt.get());
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productoRepo.findAll();
	}

	@Override
	public List<Product> saveList(List<Product> productos) {
		return productoRepo.saveAll(productos);
	}

	@Override
	public Product findProductByCode(String cod) {
		return productoRepo.findByCod(cod);
	}

	@Override
	public Product findProductById(Long idProduct) {
		return productoRepo.getById(idProduct);
	}
}