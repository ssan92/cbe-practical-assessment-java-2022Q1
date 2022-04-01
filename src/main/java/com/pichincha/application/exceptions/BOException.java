package com.pichincha.application.exceptions;

import java.util.Locale;

import com.pichincha.application.useful.MessagesUseful;
import com.sun.istack.NotNull;

public class BOException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final Locale localeDefault = new Locale("es", "EC");
	private String codeMessage;
	private Object[] messageParametersValues;
	private Object data;

	public BOException() {
		super();
	}

	public BOException(String codeMessage, Throwable cause) {
		super(MessagesUseful.getMessage(codeMessage, localeDefault), cause);
		this.codeMessage  = codeMessage;
	}

	public BOException(String codeMessage) {
		super(MessagesUseful.getMessage(codeMessage, localeDefault));
		this.codeMessage  = codeMessage;
	}

	public BOException(Throwable cause) {
		super(cause);
	}
		
	public BOException(String codeMessage, @NotNull Object[] messageParametersValues) {
		super(MessagesUseful.getMessage(codeMessage, messageParametersValues, localeDefault));
		this.codeMessage  = codeMessage;
		this.messageParametersValues = messageParametersValues;
	}
	
//	public BOException(String codeMessage, @NotNull Object[] messageParametersValues, @NotNull Object data) {
//		super(MessagesUseful.getMessage(codeMessage, messageParametersValues, localeDefault));
//		this.codeMessage  = codeMessage;
//		this.messageParametersValues = messageParametersValues;
//		this.data = data;
//	}

	public Object getData() {
		return data;
	}

//	public void setData(Object data) {
//		this.data = data;
//	}
	
	public String getTranslatedMessage(String strLanguage) {
		Locale locale = MessagesUseful.validateSupportedLocale(strLanguage);
		return getTranslatedMessage(locale);
	}

	public String getTranslatedMessage(Locale locale) {
		if (localeDefault.equals(locale)) 
			return super.getMessage();
//		} else {
//			if (messageParametersValues != null && messageParametersValues.length > 0)
//				return MessagesUseful.getMessage(codeMessage, messageParametersValues, locale);
//			else
//				return MessagesUseful.getMessage(codeMessage, locale);
//		}
		
		return null;
	}

//	public String getCodeMessage() {
//		return codeMessage;
//	}
//
//	public Object[] getMessageParametersValues() {
//		return messageParametersValues;
//	}
}
