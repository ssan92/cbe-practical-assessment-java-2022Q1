package com.pichincha.domains.jpa;

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
@Table(name = "shop")
public class ShopJpa {

  @Id
  String id;
  @Column(name = "shop_name")
  String shopName;
  @Column
  String category;
  @ManyToOne
  @JoinColumn(name = "identification_owner")
  ShopUserJpa identificationOwner;
}
