package com.pichincha.domain.bo;

import com.pichincha.application.dto.product.ProductRequestDTO;
import com.pichincha.application.exceptions.BOException;

public interface IProductBO {

	/**
	 * Add product
	 * @author Bryan Zamora
	 * @param objProductRequestDTO
	 * @throws BOException 
	 */
	public void postProduct(ProductRequestDTO objProductRequestDTO) throws BOException;

}
