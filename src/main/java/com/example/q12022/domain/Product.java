package com.example.q12022.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Product entity")
@Table(name = "PRODUCT")
public class Product {

    @Id
    @ApiModelProperty("Product ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty("Product code")
    private String cod;

    @ApiModelProperty("Product name")
    private String name;

    @ApiModelProperty("Product price")
    private Double price;

    @ApiModelProperty("Product stock")
    private Double stock;
}