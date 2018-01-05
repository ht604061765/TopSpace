/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:21:57
 * TODO //
 */
package com.topspace.core.framework.exception;

public class BusiRuntimeException extends RuntimeException{
	

	private static final long serialVersionUID = -84465530728435614L;
	private String errorCode; // 异常代码
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BusiRuntimeException() {
		super();
	}

	public BusiRuntimeException(String message) {
		super(message);
	}

	public BusiRuntimeException(Throwable cause) {
		super(cause);
	}

	public BusiRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}


}


