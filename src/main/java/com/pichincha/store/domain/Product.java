package com.pichincha.store.domain;

import static lombok.AccessLevel.PRIVATE;

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
@Entity
@Table(name = "product")
public class Product {

  @Id
  Long id;

  @Column(name = "code")
  String code;

  @Column(name = "name")
  String name;

  @Column(name = "price")
  Double price;

  @Column(name = "stock")
  Long stock;

  @ManyToOne(targetEntity = Store.class)
  Store store;

}