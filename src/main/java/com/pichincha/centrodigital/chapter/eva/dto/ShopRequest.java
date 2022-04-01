package com.pichincha.centrodigital.chapter.eva.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopRequest {

  private Integer id;
  private String name;
  private String category;
  private UserRequest user;

}
