package com.pichincha.centrodigital.chapter.eva.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {

  private Integer id;
  private String name;
  private String category;
  private UserDto user;
}
