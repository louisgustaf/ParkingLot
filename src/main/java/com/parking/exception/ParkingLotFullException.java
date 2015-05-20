package com.parking.exception;

public class ParkingLotFullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ParkingLotFullException(String message) {
		super(message);
	}

	public ParkingLotFullException(Throwable cause) {
		super(cause);
	}

	public ParkingLotFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingLotFullException(String message, Throwable cause, boolean arg2,
			boolean arg3) {
		super(message, cause, arg2, arg3);
	}

}
