package com.example.services;

import com.example.exceptions.NoParkingLotException;
import com.example.exceptions.NoSlotException;
import com.example.exceptions.NoSuchVehicleParkedException;
import com.example.exceptions.ParkingLotAlreadyExistsException;
import com.example.exceptions.VehicleAlreadyParkedException;
import com.example.models.slots.Vehicle;

public class ParkingLotService {
	private ParkingLot parkingLot;

	public ParkingLotService() {
		super();
		parkingLot = null;
	}

	public void createParkingLot(ParkingLot parkingLot) {
		if (this.parkingLot != null) {
			throw new ParkingLotAlreadyExistsException("parking lot already exists !!!");
		}
		this.parkingLot = parkingLot;
		this.parkingLot.initializedStrategy();
	}

	public Integer park(Vehicle vehicle) throws VehicleAlreadyParkedException, NoSlotException {
		if (parkingLot == null) {
			throw new NoParkingLotException("no parking lot exists, create a parking lot !!!");
		}

		return this.parkingLot.park(vehicle);
	}

	public double unpark(String registrationNumber) throws NoSuchVehicleParkedException {
		if (parkingLot == null) {
			throw new NoParkingLotException("no parking lot exists, create a parking lot !!!");
		}

		return this.parkingLot.unpark(registrationNumber);
	}

	public void status() {
		if (parkingLot == null) {
			throw new NoParkingLotException("No ParkingLot for Status !!!");
		}

		this.parkingLot.status();
	}
}
