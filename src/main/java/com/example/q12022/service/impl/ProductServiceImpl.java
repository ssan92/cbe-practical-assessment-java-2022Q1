package com.example.q12022.service.impl;

import com.example.q12022.domain.Product;
import com.example.q12022.domain.dto.ProductDTO;
import com.example.q12022.repository.ProductRepository;
import com.example.q12022.service.ProductService;
import com.example.q12022.utils.Helpers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return Helpers.modelMapper().map(product, ProductDTO.class);
    }


    @Override
    public ProductDTO saveProduct(ProductDTO dto) {
        Product product = productRepository.save(Helpers.modelMapper().map(dto, Product.class));
        return Helpers.modelMapper().map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateStockProduct(Long id, Double stock) {
        if (stock < 5)
            throw new IllegalStateException("The stock cannot be less than 1. stock = ".concat(String.valueOf(stock)));

        Optional<Product> result = productRepository.findById(id);
        result.get().setStock(stock);
        return Helpers.modelMapper().map(productRepository.save(result.get()), ProductDTO.class);
    }
}
