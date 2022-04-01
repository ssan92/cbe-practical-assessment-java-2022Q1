package com.pichincha.centrodigital.chapter.eva.controller;

import com.pichincha.centrodigital.chapter.eva.dto.ProductDto;
import com.pichincha.centrodigital.chapter.eva.dto.ProductRequest;
import com.pichincha.centrodigital.chapter.eva.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

  private final ProductService productService;


  @PostMapping(value = "/{id}")
  public ResponseEntity<ProductDto> batchProductsByIdShop(@RequestBody ProductRequest productRequest) {
    final var productDto = productService.batchProductsByIdShot(productRequest.getIdShop());

    return ResponseEntity.ok(productDto);
  }

}
