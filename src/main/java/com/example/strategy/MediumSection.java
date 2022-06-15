package com.example.strategy;

import com.example.models.slots.Medium;
import com.example.models.slots.Slot;

public class MediumSection extends Section {

	public MediumSection(Integer lowSlotNumber, Integer highSlotNumber, Section nextSection) {
		super(lowSlotNumber, highSlotNumber, nextSection);
	}

	@Override
	public Slot processNextSlot() {
		if (slots.isEmpty()) {
			return null;
		}
		return new Medium(slots.first());
	}

}
