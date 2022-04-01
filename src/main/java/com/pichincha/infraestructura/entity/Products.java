package com.pichincha.infraestructura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: requirements
 *
 */
@Entity
@Getter
@Setter
@Table(name = "products")
@Proxy(lazy=false)
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	
	@Size(max=500)
	@Column(name = "name")
    private String name;
	
    @Column(name = "amount")
    private Integer amount;
	   
	@Size(max=1)
	@JsonIgnore
	@Column(name = "state")
    private String state;
}
