package com.pichincha.infraestructura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: TiposIdentificacion
 *
 */
@Entity
@Getter
@Setter
@Table(name = "shops_by_products")
public class ShopsByProducts implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@EqualsAndHashCode.Include
    private ShopsByProductsCPK shopsByProductsCPK;
	
	@Size(max=1)
	@Column(name = "state")
    private String state;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shop", referencedColumnName = "id", insertable = false, updatable = false)
	private Shops shops;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product", referencedColumnName = "id", insertable = false, updatable = false)
	private Products products;
	
}
