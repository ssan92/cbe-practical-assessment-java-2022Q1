package com.pichincha.controllers;

import com.pichincha.domains.dto.ShopDto;
import com.pichincha.domains.mappers.ControllerMapper;
import com.pichincha.services.IShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shop")
@RequiredArgsConstructor
public class ShopController {

  private final IShopService shopService;
  private final ControllerMapper controllerMapper;

  @PostMapping("/save")
  public ResponseEntity<Object> saveShop(@RequestBody ShopDto shopDto) {
    return new ResponseEntity<>(shopService.saveShop(controllerMapper.toShopDto(shopDto)),
        HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getShop(@PathVariable String id) {
    return new ResponseEntity<>(shopService.getShop(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteShop(@PathVariable String id) {
    shopService.deleteShop(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
