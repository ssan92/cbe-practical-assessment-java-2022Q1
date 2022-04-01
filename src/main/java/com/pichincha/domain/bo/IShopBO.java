package com.pichincha.domain.bo;

import com.pichincha.application.dto.shop.ShopRequestDTO;
import com.pichincha.application.exceptions.BOException;

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

}
