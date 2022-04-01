package com.pichincha.centrodigital.chapter.eva.mapper;

import com.pichincha.centrodigital.chapter.eva.dto.ShopDto;
import com.pichincha.centrodigital.chapter.eva.dto.ShopRequest;
import com.pichincha.centrodigital.chapter.eva.entity.ShopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShopMapper {


  @Mapping(target = "user", source = "user")
  ShopEntity toEntity(ShopRequest shopRequest);

  ShopDto toDto(ShopEntity save);

  ShopEntity toShopEntity(ShopEntity shopEntity);
}
