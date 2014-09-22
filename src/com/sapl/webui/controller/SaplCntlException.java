package com.sapl.webui.controller;


/**
 * @author VasanS
 * The base Exception class
 */
public class SaplCntlException extends Exception {

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
