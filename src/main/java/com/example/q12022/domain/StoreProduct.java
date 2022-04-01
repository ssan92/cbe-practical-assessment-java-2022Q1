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
@ApiModel("StoreProduct entity")
@Table(name = "STORE_PRODUCT")
public class StoreProduct {

    @Id
    @ApiModelProperty("StoreProduct ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty("Store identification")
    @Column(name = "store_id")
    private Long storeId;

    @ApiModelProperty("Product identification")
    @Column(name = "product_id")
    private Long productId;
}
