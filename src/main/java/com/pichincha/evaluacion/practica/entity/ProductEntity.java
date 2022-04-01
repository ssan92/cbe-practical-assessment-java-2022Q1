package com.pichincha.evaluacion.practica.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "product_code", nullable = false)
    private String code;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "product_cost", nullable = false)
    private String cost;
    @Column(name = "product_stock", nullable = false)
    private String stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProductXUserEntity productXUserEntity;
}
