package com.pichincha.application.useful;

import org.apache.commons.lang3.ObjectUtils;

import com.pichincha.application.exceptions.BOException;

public class GenericUseful {
	
	private GenericUseful() {
		
	}

	public static <T> void validateFieldRequired(T objCampoRequerido, String strNombreCampo) throws BOException {
	 	if (ObjectUtils.isEmpty(objCampoRequerido) && !ObjectUtils.isEmpty(strNombreCampo)) {
			throw new BOException("msg.warn.obligatoryField", new Object[] { strNombreCampo });
		}
	}
	
	public static <T> void validateHeaderRequired(T objCampoRequerido, String strNombreCampo) throws BOException {
	 	if (ObjectUtils.isEmpty(objCampoRequerido) && !ObjectUtils.isEmpty(strNombreCampo)) {
			throw new BOException("msg.warn.obligatoryHeader", new Object[] { strNombreCampo });
		}
	}
}
