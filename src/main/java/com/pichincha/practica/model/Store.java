package com.pichincha.practica.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pichincha.practica.dto.StoreDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tienda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Store extends Base {
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "categoria")
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "propietario", insertable = false, updatable = false, nullable = false)
	private User owner;

	@Column(name = "propietario")
	private Long ownerId;
	
	public Store(Long id, String name, String category, Long ownerId, LocalDateTime creationDate) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.ownerId = ownerId;
		this.creationDate = creationDate;
	}
	
	public StoreDTO toDTO() {
		return new StoreDTO(id, name, category, ownerId, creationDate);
	}
}
