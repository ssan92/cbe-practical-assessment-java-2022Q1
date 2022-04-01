package com.pichincha.domains.jpa;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class ProductJpa {

  @Id
  Integer id;
  @Column
  String cod;
  @Column
  String name;
  @Column
  BigDecimal price;
  @Column
  Integer stock;
  @ManyToOne
  @JoinColumn(name = "id_shop")
  ShopJpa idShop;
}
