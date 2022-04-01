package com.bp.chapter.test.ChapterTest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = true)
    private Double price;

    @Column(name = "cant_stock", nullable = false)
    private Long cantStock;



}
