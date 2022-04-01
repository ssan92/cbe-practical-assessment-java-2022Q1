package com.pichincha.domains.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "order_detail")
public class OrderDetailJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;
  @Column
  Integer stock;
  @ManyToOne
  @JoinColumn(name = "order_id")
  OrderJpa orderId;
  @ManyToOne
  @JoinColumn(name = "product_id")
  ProductJpa productJpa;
}
