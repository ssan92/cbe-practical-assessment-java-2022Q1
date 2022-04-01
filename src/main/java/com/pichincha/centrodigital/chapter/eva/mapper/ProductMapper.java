package com.pichincha.centrodigital.chapter.eva.mapper;

import com.pichincha.centrodigital.chapter.eva.dto.ProductDto;
import com.pichincha.centrodigital.chapter.eva.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductEntity toEntity(ProductDto productDto);

  ProductDto toDto(ProductEntity productEntity);

}
