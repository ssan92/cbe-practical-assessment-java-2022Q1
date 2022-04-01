package com.example.q12022.service;

import com.example.q12022.controller.ProductController;
import com.example.q12022.domain.dto.ProductDTO;
import com.example.q12022.domain.dto.Response;
import com.example.q12022.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceImplTest {

    @MockBean
    private ProductServiceImpl productServiceImplMock;

    @Autowired
    private ProductController productController;

    @Test
    void getProduct() {
        ProductDTO product = new ProductDTO(1L, "prod-1", "prod-name-1", 5.5, 10.0);

        when(productServiceImplMock.getProduct(1L)).thenReturn(product);

    }

    @Test()
    void updateStockProduct() {
        ProductDTO product = new ProductDTO(1L, "prod-1", "prod-name-1", 5.5, 11.0);

        when(productServiceImplMock.updateStockProduct(product.getId(), product.getStock())).thenReturn(product);

    }
}