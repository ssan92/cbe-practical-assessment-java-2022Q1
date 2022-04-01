package com.pichincha.application.useful;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.application.exceptions.BOException;
import com.pichincha.domain.dao.IUsersDAO;
import com.pichincha.infraestructura.Users;

@Service
public class ValidateJpaUseful {
	
	@Autowired
	private IUsersDAO objIUsersDAO;
	
	private ValidateJpaUseful() {

	}
   
	public Users findUsersByUserWithValidation(String strUser) throws BOException {
		
		//Find User
		Users objUsers=objIUsersDAO.findUsersByUser(strUser);
		
		// Valide if exist
		if (ObjectUtils.isEmpty(objUsers)) {
			throw new BOException("msg.warn.userNoExist", new Object[] {strUser});
		}

		// // Valide if active
		if ((objUsers.getState()==null || !"S".equalsIgnoreCase(objUsers.getState()))) {
			throw new BOException("msg.warn.userInactive", new Object[] {strUser});
		}
		return objUsers;
		
	}
}
