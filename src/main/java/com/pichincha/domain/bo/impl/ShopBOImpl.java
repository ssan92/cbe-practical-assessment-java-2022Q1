package com.pichincha.domain.bo.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.application.dto.shop.ShopRequestDTO;
import com.pichincha.application.enums.StateEnum;
import com.pichincha.application.exceptions.BOException;
import com.pichincha.application.useful.GenericUseful;
import com.pichincha.application.useful.ValidateJpaUseful;
import com.pichincha.domain.bo.IShopBO;
import com.pichincha.domain.dao.IShopsDAO;
import com.pichincha.infraestructura.entity.Shops;

@Service
public class ShopBOImpl implements IShopBO {
	
	@Autowired
	private IShopsDAO objIShopsDAO;
	@Autowired
	private ValidateJpaUseful objValidateJpaUseful;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class}) 
	public void postShop(ShopRequestDTO objShopRequestDTO,String strUser) throws BOException {
		
		//Validate required fields
		GenericUseful.validateHeaderRequired(strUser, "msg.field.user");
		GenericUseful.validateFieldRequired(objShopRequestDTO.getName(), "msg.field.name");
		GenericUseful.validateFieldRequired(objShopRequestDTO.getCategory(), "msg.field.category");
		
		//Valide user
		objValidateJpaUseful.findUsersByUserWithValidation(strUser);
		
		//Find shop
		Shops objShops=objIShopsDAO.findShopByName(objShopRequestDTO.getName());
		
		//Valide if exists
		if(ObjectUtils.isEmpty(objShops)) {
			objShops=new Shops();
		}
		
		//Setea
		objShops.setName(objShopRequestDTO.getName().toUpperCase());
		objShops.setCategory(objShopRequestDTO.getCategory().toUpperCase());
		objShops.setState(StateEnum.ACTIVE.getName());
		objShops.setUser(strUser.toUpperCase());
		
		//Save
		objIShopsDAO.save(objShops);

		
	}

	@Override
	public Shops getShop(String strName) throws BOException {
		//Validate required fields
		GenericUseful.validateFieldRequired(strName, "msg.field.name");
		return objIShopsDAO.findShopByName(strName);
	}

	@Override
	public Shops getShopById(Integer intId) throws BOException {
		//Validate required fields
		GenericUseful.validateFieldRequired(intId, "msg.field.id");
		return objIShopsDAO.findById(intId).orElse(null);
	}

}
