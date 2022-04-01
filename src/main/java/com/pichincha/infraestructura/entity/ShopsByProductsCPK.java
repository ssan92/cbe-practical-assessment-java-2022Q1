package com.pichincha.infraestructura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShopsByProductsCPK implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name = "id_shop")
    private Integer idShop;

    @Column(name = "id_product")
    private Integer idProduct;
	
}
