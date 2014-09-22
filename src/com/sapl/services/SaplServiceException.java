package com.sapl.services;

public class SaplServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 * @param message
	 * @param cause
	 */
	public SaplServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * constructor
	 * @param message
	 */
	public SaplServiceException(String message) {
		super(message);
	}

	/**
	 * constructor
	 * @param cause
	 */
	public SaplServiceException(Throwable cause) {
		super(cause);
	}

}
