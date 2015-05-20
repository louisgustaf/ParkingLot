package com.parking.service;

import com.parking.exception.ParkingLotException;

public interface ParkingLotService {
	
	public boolean isParkingLotFull();
	
	public int countAvailableFreeParkingSpaces() throws ParkingLotException;
	
	public int countVehicleInParkingLot();
	
	public void checkInVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotException;

	public void checkOutVehicle(String licensePlate, int exitNumber) throws ParkingLotException;

	public double calculateParkingLotFee(String licensePlate);

	public void payForParking(String licensePlate);

}
