package com.pichincha.service;

import java.util.List;

import com.pichincha.entity.Product;

public interface IProductService {

	Product saveUpdate(Product product);

	void delete(Long productId);

	List<Product> getAllProducts();

	List<Product> saveList(List<Product> products);

	Product findProductByCode(String cod);

	Product findProductById(Long productId);
}
