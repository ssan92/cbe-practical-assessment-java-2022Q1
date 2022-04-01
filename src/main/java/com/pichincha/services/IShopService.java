package com.pichincha.services;

import com.pichincha.domains.dto.ShopDto;
import com.pichincha.domains.jpa.ShopJpa;

public interface IShopService {

  ShopJpa getShop(String id);

  void deleteShop(String id);

  ShopJpa saveShop(ShopDto shopDto);
}
