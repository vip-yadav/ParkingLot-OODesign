package com.example.helper;

public class OutPrinter {
	public void welcome() {
		printStatement(".........Welcome to parking lot system.........");
	}

	public void invalidFile() {
		printStatement("Given fileName for FileMode, is invalid.......");
	}

	public void createParkingLotSuccess() {
		printStatement("ParkingLot created successfully...");
	}

	public void parkedSuccess(String registrationNumber, Integer slotId) {
		System.out.println("Vehicle with registration No. " + registrationNumber + " parked at " + slotId);
	}

	public void unParkedSuccess(double cost) {
		System.out.println("Total cost for parking is : " + cost);
	}

	public void exitSuccess() {
		printStatement("exiting from system .....");
	}

	public void statusHeader() {
		printStatement("All vehicle details parked currently in parkingLot.....");
	}

	private void printStatement(String message) {
		System.out.println(message);

	}

}
