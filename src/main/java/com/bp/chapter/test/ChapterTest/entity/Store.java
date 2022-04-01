package com.bp.chapter.test.ChapterTest.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "store")
public class Store implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;
}
