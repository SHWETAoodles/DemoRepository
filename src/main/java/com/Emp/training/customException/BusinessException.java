package com.Emp.training.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getErrorCode() {
		return errorCode;
	}
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String errorCode;
	private String errorMessage;

}
