package com.miguelmejia.q12022.controller;

import com.miguelmejia.q12022.entity.Product;
import com.miguelmejia.q12022.presenter.ProductPresenter;
import com.miguelmejia.q12022.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/stock")
    public void createProductStock(@RequestParam Long id) {
        productService.generateStock(id);
    }

    @GetMapping("/products")
    public List<ProductPresenter> findAll() {
        return productService.findAll();
    }
}
