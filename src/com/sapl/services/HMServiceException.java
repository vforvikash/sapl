package com.sapl.services;

public class HMServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 * @param message
	 * @param cause
	 */
	public HMServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * constructor
	 * @param message
	 */
	public HMServiceException(String message) {
		super(message);
	}

	/**
	 * constructor
	 * @param cause
	 */
	public HMServiceException(Throwable cause) {
		super(cause);
	}

}
