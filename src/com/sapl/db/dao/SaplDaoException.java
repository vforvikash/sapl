package com.sapl.db.dao;

public class SaplDaoException extends Exception {

	/**
	 * serialVersionId
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 * @param cause
	 */
	public SaplDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * @param message
	 */
	public SaplDaoException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * @param cause
	 */
	public SaplDaoException(Throwable cause) {
		super(cause);
	}
	
}
