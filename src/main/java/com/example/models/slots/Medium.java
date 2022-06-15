package com.example.models.slots;

public class Medium extends Slot {

	public Medium(Integer slotId) {
		super(slotId, SlotCategory.Medium);
	}

	@Override
	public double getCost(Long duration) {
		return (double) (0.80 * duration);
	}

}
