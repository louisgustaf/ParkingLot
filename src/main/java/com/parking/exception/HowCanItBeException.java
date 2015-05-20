package com.parking.exception;

public class HowCanItBeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HowCanItBeException(String message) {
		super(message);
	}

	public HowCanItBeException(Throwable cause) {
		super(cause);
	}

	public HowCanItBeException(String message, Throwable cause) {
		super(message, cause);
	}

	public HowCanItBeException(String message, Throwable cause, boolean arg2,
			boolean arg3) {
		super(message, cause, arg2, arg3);
	}

}
