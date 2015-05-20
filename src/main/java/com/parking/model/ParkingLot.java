package com.parking.model;

import com.parking.exception.HowCanItBeException;
import com.parking.exception.ParkingLotFullException;
import com.parking.exception.VehicleNotFoundException;


public interface ParkingLot {
	
	/**
	 * @param licensePlate
	 * @param exitNumber
	 * @throws VehicleNotFoundException
	 */
	public void removeVehicle(String licensePlate, int exitNumber) throws VehicleNotFoundException;
	
	/**
	 * @param entrance
	 * @param licensePlate
	 * @param color
	 * @param brand
	 * @param model
	 * @throws ParkingLotFullException
	 */
	public void receiveVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotFullException;
	
	/**
	 * @return boolean
	 */
	public boolean isFull();
	
	/**
	 * @return int
	 * @throws HowCanItBeException
	 */
	public int availableParkingSpaces() throws HowCanItBeException;
	
	/**
	 * @param licensePlate
	 * @return double
	 */
	public double calculateAmountToPay(String licensePlate);
	
	/**
	 * @return int
	 */
	public int countVehicles();
	
	/**
	 * @param licensePlate
	 */
	public void checkOutTicket(String licensePlate);
	
	
}
