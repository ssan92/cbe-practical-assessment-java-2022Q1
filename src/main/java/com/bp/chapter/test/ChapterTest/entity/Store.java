package com.bp.chapter.test.ChapterTest.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "store")
public class Store implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identifier", nullable = false, unique = true)
    private String identifier;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "direction", nullable = false)
    private String direction;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;
}
