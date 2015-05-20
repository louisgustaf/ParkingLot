package com.parking.model;

public class Vehicle {
		
	private final String color;
	
	private final String brand;
	
	private final String model;
	
	private final Ticket ticket;
	
	private final String licensePlate;
	
	public Vehicle(String licensePlate, String color, String brand, String model, Ticket ticket){
		this.licensePlate = licensePlate;
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.ticket = ticket;
	}
	public Vehicle(String licensePlate, String color, String brand, String model){
		this.licensePlate = licensePlate;
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.ticket = new Ticket();
	}
	public String getColor() {
		return color;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public Ticket getTicket() {
		return ticket;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}
}
