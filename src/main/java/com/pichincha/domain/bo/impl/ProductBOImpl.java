package com.pichincha.domain.bo.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.application.dto.product.ProductRequestDTO;
import com.pichincha.application.enums.StateEnum;
import com.pichincha.application.exceptions.BOException;
import com.pichincha.application.useful.GenericUseful;
import com.pichincha.domain.bo.IProductBO;
import com.pichincha.domain.dao.IProductsDAO;
import com.pichincha.infraestructura.entity.Products;

@Service
public class ProductBOImpl implements IProductBO {
	
	@Autowired
	private IProductsDAO objIProductsDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class}) 
	public void postProduct(ProductRequestDTO objProductRequestDTO) throws BOException {
		
		//Validate required fields
		GenericUseful.validateFieldRequired(objProductRequestDTO.getName(), "msg.field.name");
		GenericUseful.validateFieldRequired(objProductRequestDTO.getAmout(), "msg.field.amout");
		
		//Find Products
		Products objProducts=objIProductsDAO.findProductByName(objProductRequestDTO.getName());
		
		//Valide if exists
		if(ObjectUtils.isEmpty(objProducts)) {
			objProducts=new Products();
		}
		
		//Setea
		objProducts.setName(objProductRequestDTO.getName().toUpperCase());
		objProducts.setAmount(objProductRequestDTO.getAmout());
		objProducts.setState(StateEnum.ACTIVE.getName());
		
		//Save
		objIProductsDAO.save(objProducts);
		
	}

}
