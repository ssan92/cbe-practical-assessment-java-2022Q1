package com.pichincha.chapter.domain.jpa;

import com.pichincha.chapter.domain.dto.store.response.ProductIdNameTo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COD")
    private String cod;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STOCK")
    private Integer stock;

    @Transient
    public ProductIdNameTo getIdName() {
        return ProductIdNameTo.builder().id(getId()).name(getName()).build();
    }

}
