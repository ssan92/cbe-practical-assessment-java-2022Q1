package com.example.q12022.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ApiModel("Transaction entity")
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @ApiModelProperty("Transaction ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ApiModelProperty("Store identification")
    @Column(name = "store_id")
    private Long storeId;

    @ApiModelProperty("Customer identification")
    @Column(name = "customer_id")
    private Long customerId;

    @ApiModelProperty("Transaction date")
    private Date date;

    @ApiModelProperty("Transaction total")
    private Double total;

    @Transient
    private List<TransactionDetail> detail;

    public Transaction() {
        detail = new ArrayList<>();
        total = 0.0;
    }
}
