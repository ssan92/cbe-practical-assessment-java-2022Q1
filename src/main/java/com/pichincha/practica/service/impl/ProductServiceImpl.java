package com.pichincha.practica.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.practica.dto.ProductDTO;
import com.pichincha.practica.exception.ApplicationException;
import com.pichincha.practica.model.Product;
import com.pichincha.practica.repository.ProductRepository;
import com.pichincha.practica.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public ProductDTO save(ProductDTO product) throws ApplicationException {
		return repo.save(product.toEntity()).toDTO();
	}

	@Override
	public ProductDTO update(Long id, ProductDTO product) throws ApplicationException {
		Optional<ProductDTO> data = findById(id);
		if (data.isPresent()) {
			Product objProduct = product.toEntity();
			objProduct.setId(id);
			objProduct.setCod(product.getCod());
			objProduct.setName(product.getName());
			objProduct.setPrice(product.getPrice());
			objProduct.setStock(product.getStock());
			objProduct.setCreationDate(data.get().getCreationDate());
			return repo.save(objProduct).toDTO();
		} else {
			throw new ApplicationException("Not exists");
		}
	}

	@Override
	public List<ProductDTO> findAll() {
		List<Product> products = repo.findAll();		
		return products.stream().map(c -> c.toDTO()).collect(Collectors.toList());
	}

	@Override
	public Optional<ProductDTO> findById(Long id) throws ApplicationException {
		Optional<Product>  product = repo.findById(id);
		Optional<ProductDTO> productDTO = Optional.empty();
		if(product.isPresent()) {			
			productDTO =  Optional.of(product.get().toDTO());
		}
		return productDTO;
	}

	@Override
	public void delete(Long id) throws ApplicationException {
		Optional<ProductDTO> data = findById(id);
		if (data.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new ApplicationException("Not exists");
		}
		
	}

	@Override
	public boolean saveByList(Long storeId, List<ProductDTO> products) throws ApplicationException {
		// TODO Auto-generated method stub
		if(!products.isEmpty()) {
			for (ProductDTO productDTO : products) {
				productDTO.setStoreId(storeId);
				this.save(productDTO);
			}
			return true;
		} else {
			throw new ApplicationException("Empty BDD");
		}
		
	}

}