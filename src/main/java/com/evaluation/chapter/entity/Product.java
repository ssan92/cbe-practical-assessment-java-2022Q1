package com.evaluation.chapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

  @Id
  @Column(nullable = false)
  private Long id;

  private String cod;
  private String name;
  private String price;
  private Long stock;

  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store productStore;
}
