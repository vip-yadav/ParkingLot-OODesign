package com.example.services;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.exceptions.NoSlotException;
import com.example.exceptions.NoSuchVehicleParkedException;
import com.example.exceptions.VehicleAlreadyParkedException;
import com.example.models.slots.Slot;
import com.example.models.slots.Vehicle;
import com.example.services.message.Message;
import com.example.strategy.ParkingStrategy;

public class ParkingLot {
	private final int MAX_CAPACITY = 1000;
	private ParkingStrategy parkingStrategy;
	private Integer capacity;

	// { vehicleRegistrationNumber -> slot }
	private HashMap<String, Slot> vehicleNoToSlotId;

	public ParkingLot(ParkingStrategy parkingStrategy) {
		this.capacity = MAX_CAPACITY;
		this.parkingStrategy = parkingStrategy;
		this.vehicleNoToSlotId = new HashMap<>();
	}

	public ParkingLot(ParkingStrategy parkingStrategy, int capacity) {
		this.capacity = (capacity > MAX_CAPACITY) ? MAX_CAPACITY : capacity;
		this.parkingStrategy = parkingStrategy;
		this.vehicleNoToSlotId = new HashMap<>();
	}

	public void initializedStrategy() {
		parkingStrategy.initialize(capacity);
	}

	public Integer park(Vehicle vehicle) {
		String registrationNumber = vehicle.getRegistrationNumber();
		if (vehicleNoToSlotId.containsKey(registrationNumber)) {
			throw new VehicleAlreadyParkedException("vehicle already parked in parking lot !!!");
		}
		Slot availableSlot = parkingStrategy.getNextSlot(vehicle.getCategory());
		if (availableSlot != null) {
			synchronized (this) {
				availableSlot.assignVehicleToSlot(vehicle);
				vehicleNoToSlotId.put(registrationNumber, availableSlot);
				parkingStrategy.removeSlot(availableSlot.getSlotId());
			}
			return availableSlot.getSlotId();

		} else {
			throw new NoSlotException("no available slot found !!!");
		}
	}

	public double unpark(String registrationNumber) {
		if (!vehicleNoToSlotId.containsKey(registrationNumber)) {
			throw new NoSuchVehicleParkedException("No such vehicle parked currently");
		}
		Slot slot = vehicleNoToSlotId.get(registrationNumber);
		double cost = 0;
		synchronized (this) {
			cost = slot.getCost(Instant.now().toEpochMilli() - slot.getStartingTime().toEpochMilli());
			slot.unassingVehicleToSlot();
			parkingStrategy.addSlot(slot.getSlotId());
			vehicleNoToSlotId.remove(registrationNumber);
		}

		return cost;
	}

	public void status() {
		for (Map.Entry<String, Slot> entry : vehicleNoToSlotId.entrySet()) {
			System.out.println(new Message(entry.getKey(), entry.getValue().getVehicle().getColor(),
					entry.getValue().getVehicle().getCategory().getCategoryType(),
					entry.getValue().getCategory().getCategoryType(), entry.getValue().getSlotId(),
					new Date(entry.getValue().getStartingTime().toEpochMilli())).toString());
		}
	}

}
