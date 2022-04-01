package com.pichincha.centrodigital.chapter.eva.controller;

import com.pichincha.centrodigital.chapter.eva.dto.ShopDto;
import com.pichincha.centrodigital.chapter.eva.dto.ShopRequest;
import com.pichincha.centrodigital.chapter.eva.service.ShopService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/shops")
public class ShopController {

  private final ShopService shopService;

  @GetMapping
  public ResponseEntity<List<ShopDto>> getProduct() {
    List<ShopDto> shops = shopService.getAll();

    return ResponseEntity.ok(shops);
  }

  @PostMapping
  public ResponseEntity<ShopDto> createShop(@Valid @RequestBody ShopRequest shopRequest) {
    final var shopDto = shopService.createShop(shopRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(shopDto);
  }

  @GetMapping(value = "/{name}")
  public ResponseEntity<ShopDto> getShopByName(@PathVariable("name") String name) {
    final var shop = shopService.getShopByName(name);

    return ResponseEntity.ok(shop);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ShopDto> updateShop(@PathVariable("id") Integer id,
      @RequestBody ShopRequest shopRequest) {
    final var updateShop = shopService.updateShop(id, shopRequest);

    return ResponseEntity.ok(updateShop);
  }


}
