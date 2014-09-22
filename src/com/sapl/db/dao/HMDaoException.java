package com.sapl.db.dao;

public class HMDaoException extends Exception {

	/**
	 * serialVersionId
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param message
	 * @param cause
	 */
	public HMDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * @param message
	 */
	public HMDaoException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * @param cause
	 */
	public HMDaoException(Throwable cause) {
		super(cause);
	}
	
}
