package com.evaluation.chapter.controller;

import com.evaluation.chapter.domain.PostProduct;
import com.evaluation.chapter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store")
public class StoreController {

  @Autowired
  ProductService productService;

  @PostMapping("/user/products/{userId}")
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody PostProduct postProduct, @PathVariable String userId) {
    productService.createService(postProduct, userId);
  }

  @PostMapping("/products/{store}")
  @ResponseStatus(HttpStatus.CREATED)
  public void generateProducts(@PathVariable String store) {
    productService.createMockProducts(store);
  }

//  @GetMapping("/product/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  public Product getProduct(@PathVariable String id) {
//    return productService.getProduct(id);
//  }
}
