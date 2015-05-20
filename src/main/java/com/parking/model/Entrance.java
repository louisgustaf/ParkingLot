package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class Entrance {
	
	private final String location;
	
	private final List<Vehicle> checkInLine;
	
	public Entrance(String location){
		this.location = location;
		checkInLine = new ArrayList<Vehicle>();
	}
	
	protected void checkInVehicle(){
		checkInLine.remove(0);		
	}
	
	public void addVehicleToLine(Vehicle vehicle){
		checkInLine.add(vehicle);
	}
	
	public Vehicle getNextVehicleInline(){
		return this.checkInLine.get(0);
	}

	public String getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((checkInLine == null) ? 0 : checkInLine.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
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
		Entrance other = (Entrance) obj;
		if (checkInLine == null) {
			if (other.checkInLine != null)
				return false;
		} else if (!checkInLine.equals(other.checkInLine))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

}
