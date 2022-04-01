package com.pichincha.domains.mappers;

import com.pichincha.domains.dto.RequestOrderDto;
import com.pichincha.domains.dto.RequestProductDto;
import com.pichincha.domains.dto.ShopDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ControllerMapper {

  ShopDto toShopDto(ShopDto shopDto);

  RequestProductDto toRequestProductDto(RequestProductDto requestProductDto);

  RequestOrderDto toRequestOrderDto(RequestOrderDto orderDto);
}
