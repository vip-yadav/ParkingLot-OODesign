package com.example.models.slots;

import java.time.Instant;

public abstract class Slot {
	private Integer slotId;
	private Vehicle vehicle;
	private SlotCategory category;
	private Instant startingTime;

	public Slot(Integer slotId, SlotCategory category) {
		super();
		this.slotId = slotId;
		this.category = category;
	}

	public Integer getSlotId() {
		return slotId;
	}

	public boolean isSlotFree() {
		return (this.vehicle == null) ? true : false;
	}

	public void assignVehicleToSlot(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.startingTime = Instant.now();

	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Instant getStartingTime() {
		return startingTime;
	}

	public void unassingVehicleToSlot() {
		this.vehicle = null;
	}

	public SlotCategory getCategory() {
		return category;
	}

	public abstract double getCost(Long duration);
}
