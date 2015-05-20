package com.parking.model;

import com.parking.exception.HowCanItBeException;
import com.parking.exception.ParkingLotFullException;
import com.parking.exception.VehicleNotFoundException;


public interface ParkingLot {
	
	public void removeVehicle(String licensePlate, int exitNumber) throws VehicleNotFoundException;
	
	public void receiveVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotFullException;
	
	public boolean isFull();
	
	public int availableParkingSpaces() throws HowCanItBeException;
	
	public double calculateAmountToPay(String licensePlate);
	
	public int countVehicles();
	
	public void checkOutTicket(String licensePlate);
	
	
}
