package com.example.strategy;

import com.example.models.slots.Slot;
import com.example.models.slots.TwoWheeler;

public class TwoWheelerSection extends Section {

	public TwoWheelerSection(Integer lowestSlotNumber, Integer highSlotNumber, Section nextSection) {
		super(lowestSlotNumber, highSlotNumber, nextSection);
	}

	@Override
	public Slot processNextSlot() {
		if (slots.isEmpty()) {
			return nextSection.processNextSlot();
		}

		return new TwoWheeler(slots.first());
	}

}
