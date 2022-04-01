package com.pichincha.domains.mappers;

import com.pichincha.domains.dto.ProductDto;
import com.pichincha.domains.dto.ShopDto;
import com.pichincha.domains.jpa.ProductJpa;
import com.pichincha.domains.jpa.ShopJpa;
import com.pichincha.domains.jpa.ShopUserJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

  @Mapping(target = "identificationOwner", source = "userJpa")
  ShopJpa toShopJpa(ShopDto shopDto, ShopUserJpa userJpa);

  @Mapping(target = "id", source = "prodDto.id")
  @Mapping(target = "idShop", source = "shopJpa")
  ProductJpa toProductJpa(ProductDto prodDto, ShopJpa shopJpa);
}
