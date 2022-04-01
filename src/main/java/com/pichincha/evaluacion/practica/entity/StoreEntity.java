package com.pichincha.evaluacion.practica.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "store_name", nullable = false)
    private String name;
    @Column(name = "store_category", nullable = false)
    private String category;
    @Column(name = "store_owner", nullable = false)
    private String owner;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private ReportEntity reportEntity;
}