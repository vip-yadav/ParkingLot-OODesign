package com.example.models.slots;

public class TwoWheeler extends Slot {

	public TwoWheeler(Integer slotId) {
		super(slotId, SlotCategory.TwoWheeler);
	}

	@Override
	public double getCost(Long duration) {
		return (double) (0.10 * duration);
	}

}
