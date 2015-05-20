package com.parking.service;

import com.parking.exception.ParkingLotException;

public interface ParkingLotService {
	
	/**
	 * @return boolean
	 */
	public boolean isParkingLotFull();
	
	/**
	 * @return
	 * @throws ParkingLotException
	 */
	public int countAvailableFreeParkingSpaces() throws ParkingLotException;
	
	/**
	 * @return int
	 */
	public int countVehicleInParkingLot();
	
	/**
	 * @param entrance
	 * @param licensePlate
	 * @param color
	 * @param brand
	 * @param model
	 * @throws ParkingLotException
	 */
	public void checkInVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotException;

	/**
	 * @param licensePlate
	 * @param exitNumber
	 * @throws ParkingLotException
	 */
	public void checkOutVehicle(String licensePlate, int exitNumber) throws ParkingLotException;

	/**
	 * @param licensePlate
	 * @return double
	 */
	public double calculateParkingLotFee(String licensePlate);

	/**
	 * @param licensePlate
	 */
	public void payForParking(String licensePlate);

}
