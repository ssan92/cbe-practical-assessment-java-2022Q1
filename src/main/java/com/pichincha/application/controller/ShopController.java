package com.pichincha.application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.application.dto.general.ResponseOkDTO;
import com.pichincha.application.dto.shop.ShopRequestDTO;
import com.pichincha.application.exceptions.BOException;
import com.pichincha.application.exceptions.CustomExceptionHandler;
import com.pichincha.application.useful.MessagesUseful;
import com.pichincha.domain.bo.IShopBO;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private IShopBO objIShopBO;
	
	private static final String HTTP_OK = "msg.response.ok";
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postShop(
			@RequestHeader(	value = "Accept-Language", 	required = false) String strLanguage, 
			@RequestHeader(	value = "user",required = false) String strUser, 
			@RequestBody ShopRequestDTO objShopRequestDTO) throws BOException {
		
		try {	
			objIShopBO.postShop(objShopRequestDTO,strUser);
			return new ResponseEntity<>(new ResponseOkDTO(
					MessagesUseful.getMessage(HTTP_OK, MessagesUseful.validateSupportedLocale(strLanguage)),
					new HashMap<>()), HttpStatus.OK);
		} catch (BOException be) {
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getShop(
			@RequestHeader(	value = "Accept-Language", 	required = false) String strLanguage, 
			@RequestParam(	value = "name",required = false) String strName
			) throws BOException {
		
		try {	
			return new ResponseEntity<>(new ResponseOkDTO(
					MessagesUseful.getMessage(HTTP_OK, MessagesUseful.validateSupportedLocale(strLanguage)),
					objIShopBO.getShop(strName)), HttpStatus.OK);
		} catch (BOException be) {
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
	
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getShopById(
			@RequestHeader(	value = "Accept-Language", 	required = false) String strLanguage, 
			@PathVariable(	value = "id",required = false) Integer intId
			) throws BOException {
		
		try {	
			return new ResponseEntity<>(new ResponseOkDTO(
					MessagesUseful.getMessage(HTTP_OK, MessagesUseful.validateSupportedLocale(strLanguage)),
					objIShopBO.getShopById(intId)), HttpStatus.OK);
		} catch (BOException be) {
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
	
	}
}
