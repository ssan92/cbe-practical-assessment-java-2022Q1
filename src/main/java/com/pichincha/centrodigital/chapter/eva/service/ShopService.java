package com.pichincha.centrodigital.chapter.eva.service;

import com.pichincha.centrodigital.chapter.eva.dto.ShopDto;
import com.pichincha.centrodigital.chapter.eva.dto.ShopRequest;
import java.util.List;

public interface ShopService {

  ShopDto createShop(ShopRequest shopRequest);

  ShopDto getShopByName(String name);

  List<ShopDto> getAll();

  ShopDto updateShop(Integer id, ShopRequest shopRequest);
}
