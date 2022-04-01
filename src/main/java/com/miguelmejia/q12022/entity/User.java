package com.miguelmejia.q12022.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private LocalDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Store> stores;
}
