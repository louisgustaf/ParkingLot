package com.parking.exception;

public class ParkingLotException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkingLotException(String message) {
		super(message);
	}

	public ParkingLotException(Throwable cause) {
		super(cause);
	}

	public ParkingLotException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingLotException(String message, Throwable cause, boolean arg2,
			boolean arg3) {
		super(message, cause, arg2, arg3);
	}

}
