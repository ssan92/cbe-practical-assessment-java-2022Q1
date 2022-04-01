package com.pichincha.store.domain.dto;

import static lombok.AccessLevel.PRIVATE;

import com.pichincha.store.domain.Store;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class ProductDto {

  Long id;
  String code;
  String name;
  Double price;
  Long stock;
}