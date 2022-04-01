package com.pichincha.centrodigital.chapter.eva.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shopEntity")
public class ShopEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String category;

  /*@OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id", referencedColumnName = "id")
  private ProductEntity product;*/

  @OneToOne(mappedBy = "shop")
  private UserEntity user;
}
