package com.example.q12022.service;

import com.example.q12022.domain.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    ProductDTO getProduct(Long id);

    ProductDTO saveProduct(ProductDTO dto);

    ProductDTO updateStockProduct(Long id, Double stock);
}
