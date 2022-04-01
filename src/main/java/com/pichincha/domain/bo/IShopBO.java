package com.pichincha.domain.bo;

import com.pichincha.application.dto.shop.ShopRequestDTO;
import com.pichincha.application.exceptions.BOException;
import com.pichincha.infraestructura.entity.Shops;

public interface IShopBO {
	/**
	 * Create the store
	 * 
	 * @author Bryan Zamora
	 * @param objShopRequestDTO
	 * @param strUser
	 * @throws BOException
	 */
	public void postShop(ShopRequestDTO objShopRequestDTO,String strUser)throws BOException;

	/**
	 * Get Shop by name
	 * 
	 * @author Bryan Zamora
	 * @param strName
	 * @return
	 * @throws BOException
	 */
	public Shops getShop(String strName)throws BOException;

	/**
	 * Get Shop by id
	 * 
	 * @author Bryan Zamora
	 * @param intId
	 * @return
	 * @throws BOException
	 */
	public Shops getShopById(Integer intId)throws BOException;

}
