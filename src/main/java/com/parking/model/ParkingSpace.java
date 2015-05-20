package com.parking.model;

public class ParkingSpace {

	private String size;

	private Exit nearestExit;

	private String Type;

	private boolean occupied;

	private Vehicle vehicle;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Exit getNearestExit() {
		return nearestExit;
	}

	public void setNearestExit(Exit nearestExit) {
		this.nearestExit = nearestExit;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result
				+ ((nearestExit == null) ? 0 : nearestExit.hashCode());
		result = prime * result + (occupied ? 1231 : 1237);
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		ParkingSpace other = (ParkingSpace) obj;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (nearestExit == null) {
			if (other.nearestExit != null)
				return false;
		} else if (!nearestExit.equals(other.nearestExit))
			return false;
		if (occupied != other.occupied)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
}
