package com.example.models.slots;

public class Compact extends Slot {

	public Compact(Integer slotId) {
		super(slotId, SlotCategory.Compact);
	}

	public double getCost(Long duration) {
		return (double) (0.50 * duration);
	}

}
