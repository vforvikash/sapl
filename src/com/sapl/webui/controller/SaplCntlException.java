package com.sapl.webui.controller;


/**
 * @author Vikash
 * The base Exception class
 */
public class SaplCntlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2108361779843932869L;

	/**
	 * @param message
	 * @param cause
	 */
	public SaplCntlException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SaplCntlException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SaplCntlException(Throwable cause) {
		super(cause);
	}
}
