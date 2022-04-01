package com.pichincha.chapter.domain.jpa;

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
@Table(name = "STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long cod;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "OWNER")
    private String owner;

    @Transient
    public Store getNameCodStore() {
        return Store.builder().cod(getCod()).name(getName()).build();
    }


}
