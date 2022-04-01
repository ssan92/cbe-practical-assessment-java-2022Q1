package com.pichincha.chapter.service.impl;

import com.pichincha.chapter.domain.jpa.Product;
import com.pichincha.chapter.repository.ProductRepository;
import com.pichincha.chapter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
