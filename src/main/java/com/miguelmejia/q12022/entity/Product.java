package com.miguelmejia.q12022.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    private long id;
    private String cod;
    private String name;
    private double price;
    private long stock;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
