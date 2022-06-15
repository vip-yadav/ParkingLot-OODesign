package com.example.models.slots;

public class Vehicle {
	private String registrationNumber;
	private String color;

	private VehicleCategory category;

	public Vehicle(String registrationNumber, String color, VehicleCategory category) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.category = category;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public VehicleCategory getCategory() {
		return category;
	}

}