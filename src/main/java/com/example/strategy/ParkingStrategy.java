package com.example.strategy;

import com.example.models.slots.Slot;
import com.example.models.slots.VehicleCategory;

/*
 * abstract parking strategy, implement interface to have own parkingStrategy
 */
public interface ParkingStrategy {
	public void addSlot(Integer slotId);

	public void removeSlot(Integer slotId);

	public void initialize(int capacity);

	public Slot getNextSlot(VehicleCategory vehicleCategory);
}
