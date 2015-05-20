package com.parking.exception;

public class VehicleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VehicleNotFoundException(String message) {
		super(message);
	}

	public VehicleNotFoundException(Throwable cause) {
		super(cause);
	}

	public VehicleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleNotFoundException(String message, Throwable cause, boolean arg2,
			boolean arg3) {
		super(message, cause, arg2, arg3);
	}

}
