package com.pichincha.chapter.domain.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "STORE_PRODUCT")
public class StoreProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_STORE_PRODUCT")
    private Long codStoreProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STORE")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

}
