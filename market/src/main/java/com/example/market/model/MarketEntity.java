package com.example.market.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "market")
public class MarketEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true)
  private Integer id;

  private String name;
  private String category;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public UserEntity getUserEntity() {
    return userEntity;
  }

  public void setUserEntity(UserEntity userEntity) {
    this.userEntity = userEntity;
  }

  public MarketEntity() {}

  public MarketEntity(String name, String category, UserEntity userEntity) {
    this.name = name;
    this.category = category;
    this.userEntity = userEntity;
  }
}
