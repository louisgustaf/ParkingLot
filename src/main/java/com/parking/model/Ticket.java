package com.parking.model;

import java.util.Date;

public class Ticket {
	
	private int id;
	
	private String type;
	
	private Date entranceTime;
	
	private Date exitTime;
	
	private double valueToPay;
	
	private Vehicle vehicle;
	
	private Status status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public double getValueToPay() {
		return valueToPay;
	}

	public void setValueToPay(double valueToPay) {
		this.valueToPay = valueToPay;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {PAID, NOT_PAID, LOST}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entranceTime == null) ? 0 : entranceTime.hashCode());
		result = prime * result
				+ ((exitTime == null) ? 0 : exitTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valueToPay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ticket other = (Ticket) obj;
		if (entranceTime == null) {
			if (other.entranceTime != null)
				return false;
		} else if (!entranceTime.equals(other.entranceTime))
			return false;
		if (exitTime == null) {
			if (other.exitTime != null)
				return false;
		} else if (!exitTime.equals(other.exitTime))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(valueToPay) != Double
				.doubleToLongBits(other.valueToPay))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	};


}
