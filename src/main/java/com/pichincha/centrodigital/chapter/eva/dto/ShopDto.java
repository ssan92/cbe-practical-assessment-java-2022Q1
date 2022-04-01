package com.pichincha.centrodigital.chapter.eva.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopDto {

  private Integer id;
  private String name;
  private String category;
  private UserDto user;
}
