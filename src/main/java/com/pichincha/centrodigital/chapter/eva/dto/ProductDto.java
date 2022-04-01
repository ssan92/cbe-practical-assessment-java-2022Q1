package com.pichincha.centrodigital.chapter.eva.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

  private Integer id;
  private String cod;
  private String name;
  private Double price;
  private Integer stock;

}
