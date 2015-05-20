package com.parking.service;

import com.parking.exception.HowCanItBeException;
import com.parking.exception.ParkingLotException;
import com.parking.exception.ParkingLotFullException;
import com.parking.exception.VehicleNotFoundException;
import com.parking.model.ParkingLot;

public class PakingLotServiceImpl implements ParkingLotService{
	
	public ParkingLot parkingLot;

	@Override
	public void checkInVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotException {
		try {
			parkingLot.receiveVehicle(entrance, licensePlate, color, brand, model);
		} catch (ParkingLotFullException e) {
			throw new ParkingLotException("Parking Lot at Full capacity.", e.getCause());
		}
	}

	@Override
	public boolean isParkingLotFull() {
		return parkingLot.isFull();
	}

	@Override
	public int countAvailableFreeParkingSpaces() throws ParkingLotException {
		try {
			return parkingLot.availableParkingSpaces();
		} catch (HowCanItBeException e) {
			throw new ParkingLotException("Somehow we allowed more vehicles than it is possible.", e.getCause());
		}
	}

	@Override
	public int countVehicleInParkingLot() {
		return parkingLot.countVehicles();
	}

	@Override
	public void checkOutVehicle(String licensePlate, int exitNumber) throws ParkingLotException {
		try {
			parkingLot.removeVehicle(licensePlate, exitNumber);
		} catch (VehicleNotFoundException e) {
			throw new ParkingLotException("We are sorry, but we couldn't find your vehicle.", e.getCause());
		}
	}

	@Override
	public double calculateParkingLotFee(String licensePlate) {
		return parkingLot.calculateAmountToPay(licensePlate);
	}

	@Override
	public void payForParking(String licensePlate) {
		parkingLot.checkOutTicket(licensePlate);
		
	}
	
}
