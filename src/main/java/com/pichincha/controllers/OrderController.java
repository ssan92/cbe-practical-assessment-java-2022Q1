package com.pichincha.controllers;

import com.pichincha.domains.dto.RequestOrderDto;
import com.pichincha.domains.mappers.ControllerMapper;
import com.pichincha.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

  private final IProductService productService;
  private final ControllerMapper controllerMapper;

  @PostMapping("/save")
  public ResponseEntity<Object> saveShop(@RequestBody RequestOrderDto orderDto) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
