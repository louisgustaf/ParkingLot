package com.parking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.parking.exception.HowCanItBeException;
import com.parking.exception.ParkingLotFullException;
import com.parking.exception.VehicleNotFoundException;
import com.parking.model.Ticket.Status;

public class ParkingLotImpl implements ParkingLot{
	
	private  final Map<String, ParkingSpace> parkingSpaces;
	
	private final List<Exit> exits;
	
	private final List<Entrance> entrances;
	
	private final int capacity;
	
	private final double hourlyRate;
	
	public ParkingLotImpl(int capacity, int numberOfEntrances, int numberOfExits, double hourlyRate){
		this.capacity = capacity;
		this.hourlyRate = hourlyRate;
		
		//this is the choke point of the application
		//could be a concurrentHashMap instead if performance is affected, consistency might be compromise.
		//to circumvent this I would left some spare spots(maybe 5% of the spots depending of the concurrency level)
		//for customers affected by concurrency inconsistency
		//also could extend the hashmap class and make it fixed size
		this.parkingSpaces = Collections.synchronizedMap(new HashMap<String, ParkingSpace>(capacity, 0.99f));
		
		this.entrances = new ArrayList<Entrance>();
		int i = 0;
		for(; i < numberOfEntrances; i++){
			this.entrances.add(new Entrance("position " + i));
		}
		
		this.exits =  new ArrayList<Exit>();
		i = 0;
		for(; i < numberOfExits; i++){
			this.exits.add(new Exit("position " + i));
		}
	}

	public boolean findParkingSpaceForVehicle(Vehicle vehicle) {
		ParkingSpace parkingSpace = this.findParkingSpace();
		parkingSpace.setVehicle(vehicle);
		
		this.parkingSpaces.put(vehicle.getLicensePlate(), parkingSpace);
		
		return true;
	}
	
	private Ticket generateTicket() {
		Ticket ticket = new Ticket();
		
		Random  random = new Random();
		
		ticket.setId(random.nextInt(10000));
		ticket.setEntranceTime(new Date());
		ticket.setStatus(Status.NOT_PAID);
		
		return ticket;
	}

	private ParkingSpace findParkingSpace(){
		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setOccupied(true);
		parkingSpace.setType("commom");
		
		return parkingSpace;
	}

	public void removeVehicle(Vehicle vehicle, int exitNumber) throws VehicleNotFoundException {
		removeVehicle(vehicle.getLicensePlate(), exitNumber);
	}
	
	@Override
	public void removeVehicle(String licensePlate, int exitNumber) throws VehicleNotFoundException {
		ParkingSpace parkingSpace = this.parkingSpaces.get(licensePlate);
		if(parkingSpace == null){
			throw new VehicleNotFoundException("Call the police, get a lawyer!!!");
		}
		
		Exit exit = this.exits.get(exitNumber);
		
		exit.addVehicletoExitLine(parkingSpace.getVehicle());
		
		if(exit.checkOutCarInLine()){
			this.parkingSpaces.remove((parkingSpace.getVehicle().getLicensePlate()));
		}
	}

	@Override
	public boolean isFull() {
		if(this.parkingSpaces.size() == this.capacity){
			return true;
		}
		return false;
	}

	@Override
	public int availableParkingSpaces() throws HowCanItBeException {
		int availability = this.capacity - this.parkingSpaces.size();
		if(availability < 0){
			throw new HowCanItBeException("More parking spaces than desired!!!");
		}
		return availability;
	}
	
	private void addVechicle(String licensePlate, String color, String brand, String model){
		Ticket ticket = this.generateTicket();
		
		Vehicle vehicle = new Vehicle(licensePlate, color, brand, model, ticket);
		
		ticket.setVehicle(vehicle);
		this.findParkingSpaceForVehicle(vehicle);
	}
	
	private void addVechicleFromLine(Entrance entrance) throws ParkingLotFullException{
		if(this.isFull()){
			//This exception is optional, actually this might be a common behavior rather than an exception
			throw new ParkingLotFullException("Sorry, parking lot is currently full. Appreciate your patience.");
		}else{
			Entrance entranceOfVehicleInline = this.entrances.get(this.entrances.indexOf(entrance));
			Vehicle vehicleInline = entranceOfVehicleInline.getNextVehicleInline();
			
			addVechicle(vehicleInline.getLicensePlate(), vehicleInline.getColor(), vehicleInline.getBrand(), vehicleInline.getModel());
			
			entranceOfVehicleInline.checkInVehicle();
		}
	}
	
	@Override
	public void receiveVehicle(int entrance, String licensePlate, String color, String brand, String model) throws ParkingLotFullException{
		
		Entrance vehicleEntrance = this.entrances.get(entrance);
		
		Vehicle vehicle = new Vehicle(licensePlate, color, brand, model);
		
		vehicleEntrance.addVehicleToLine(vehicle);
		
		addVechicleFromLine(vehicleEntrance);
	}
	
	public int countVehicles(){
		return this.parkingSpaces.size();
	}

	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public void setParkingTicketToPaid(Ticket ticket) {
		checkOutTicket(ticket.getVehicle().getLicensePlate());
	}
	
	@Override
	public void checkOutTicket(String licensePlate) {
		ParkingSpace parkingSpace = this.parkingSpaces.get(licensePlate);
		parkingSpace.getVehicle().getTicket().setStatus(Status.PAID);
	}
	
	private double calculateValue(Ticket ticket) {
		return PayingHelper.calculePayingAmount(ticket, hourlyRate);
	}
	
	@Override
	public double calculateAmountToPay(String licensePlate) {
		ParkingSpace parkingSpace = this.parkingSpaces.get(licensePlate);
		
		double totalToPay = calculateValue(parkingSpace.getVehicle().getTicket());
		
		parkingSpace.getVehicle().getTicket().setValueToPay(totalToPay);
		
		return totalToPay;
	}
}
