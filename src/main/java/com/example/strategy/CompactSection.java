package com.example.strategy;

import com.example.models.slots.Compact;
import com.example.models.slots.Slot;

public class CompactSection extends Section {

	public CompactSection(Integer lowestSlotNumber, Integer highSlotNumber, Section nextSection) {
		super(lowestSlotNumber, highSlotNumber, nextSection);
	}

	@Override
	public Slot processNextSlot() {
		if (slots.isEmpty()) {
			return nextSection.processNextSlot();
		}
		return new Compact(slots.first());
	}

}
