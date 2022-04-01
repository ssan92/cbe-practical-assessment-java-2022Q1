package com.pichincha.services.impl;

import com.pichincha.domains.dto.ShopDto;
import com.pichincha.domains.exceptions.GenericException;
import com.pichincha.domains.exceptions.NotFoundException;
import com.pichincha.domains.jpa.ShopJpa;
import com.pichincha.domains.jpa.ShopUserJpa;
import com.pichincha.domains.mappers.ServiceMapper;
import com.pichincha.respositories.IShopRepository;
import com.pichincha.respositories.IShopUserRepository;
import com.pichincha.services.IShopService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ShopService implements IShopService {

  private final IShopRepository shopRepository;
  private final IShopUserRepository shopUserRepository;
  private final ServiceMapper serviceMapper;

  @Override
  public ShopJpa getShop(String id) {
    ShopJpa response = shopRepository.getShopJpaById(id).orElse(null);
    if (Objects.isNull(response)) {
      throw new NotFoundException();
    }
    return response;
  }

  @Override
  public void deleteShop(String id) {
    ShopJpa countriesJpa = getShop(id);
    shopRepository.delete(countriesJpa);
  }

  @Override
  public ShopJpa saveShop(ShopDto shopDto) {
    ShopJpa shopJpaFind = shopRepository.getShopJpaById(shopDto.getId()).orElse(null);
    if (!Objects.isNull(shopJpaFind)) {
      log.error("Shop exist register");
      throw new GenericException(HttpStatus.BAD_REQUEST, "Shop exist register");
    }
    ShopUserJpa userJpa = shopUserRepository.getShopUserJpaByIdentification(
        shopDto.getIdentificationOwner()).orElse(null);
    if (Objects.isNull(userJpa)) {
      log.error("Not exist user owner");
      throw new GenericException(HttpStatus.NOT_FOUND, "Not exist user owner");
    }
    ShopJpa response = serviceMapper.toShopJpa(shopDto, userJpa);
    shopRepository.save(response);

    return response;
  }
}
