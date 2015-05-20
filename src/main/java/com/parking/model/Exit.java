package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class Exit {
	
	private final List<Vehicle> vehiclesInExitLine;
	
	private final String location;
	
	//private boolean operational;
	
	public Exit(String location){
		this.location = location;
		vehiclesInExitLine = new ArrayList<Vehicle>();
	}
	
	public void addVehicletoExitLine(Vehicle vehicle){
		vehiclesInExitLine.add(vehicle);
	}
	
	public boolean checkOutCarInLine(){
		Vehicle vehicle = vehiclesInExitLine.remove(0);
		if(vehicle.getTicket().getStatus().equals("PAID")){
			return true;
		}else{
			return false;
		}
			
	}
	
	public String getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime
				* result
				+ ((vehiclesInExitLine == null) ? 0 : vehiclesInExitLine
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exit other = (Exit) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (vehiclesInExitLine == null) {
			if (other.vehiclesInExitLine != null)
				return false;
		} else if (!vehiclesInExitLine.equals(other.vehiclesInExitLine))
			return false;
		return true;
	}

}
