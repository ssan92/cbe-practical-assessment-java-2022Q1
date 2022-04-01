package com.pichincha.application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.application.dto.general.ResponseOkDTO;
import com.pichincha.application.dto.product.ProductRequestDTO;
import com.pichincha.application.exceptions.BOException;
import com.pichincha.application.exceptions.CustomExceptionHandler;
import com.pichincha.application.useful.MessagesUseful;
import com.pichincha.domain.bo.IProductBO;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductBO objIProductBO;
	
	private static final String HTTP_OK = "msg.response.ok";
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postProduct(
			@RequestHeader(	value = "Accept-Language", 	required = false) String strLanguage, 
			@RequestBody ProductRequestDTO objProductRequestDTO) throws BOException {
		
		try {	
			objIProductBO.postProduct(objProductRequestDTO);
			return new ResponseEntity<>(new ResponseOkDTO(
					MessagesUseful.getMessage(HTTP_OK, MessagesUseful.validateSupportedLocale(strLanguage)),
					new HashMap<>()), HttpStatus.OK);
		} catch (BOException be) {
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
	
	}
}
