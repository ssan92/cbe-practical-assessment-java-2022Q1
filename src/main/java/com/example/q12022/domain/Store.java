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
@ApiModel("Store entity")
@Table(name = "STORE")
public class Store {

    @Id
    @ApiModelProperty("Store ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty("Store name")
    private String name;

    @ApiModelProperty("Store category")
    private String category;

    @Column(name = "USER_STORE_ID")
    private Long userStoreId;
}
