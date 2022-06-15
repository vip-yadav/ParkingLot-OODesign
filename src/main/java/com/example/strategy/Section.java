package com.example.strategy;

import java.util.TreeSet;

import com.example.models.slots.Slot;

public abstract class Section {
	protected Integer lowestSlotNumber;
	protected Integer highestSlotNumber;

	protected Section nextSection;

	TreeSet<Integer> slots;

	public Section(Integer lowSlotNumber, Integer highSlotNumber, Section nextSection) {
		super();
		this.lowestSlotNumber = lowSlotNumber;
		this.highestSlotNumber = highSlotNumber;
		this.nextSection = nextSection;

		slots = new TreeSet<>();
		for (int i = lowestSlotNumber; i <= highestSlotNumber; i++) {
			slots.add(i);
		}
	}

	protected void processPark(Integer slotId) {
		if (slotId >= lowestSlotNumber && slotId <= highestSlotNumber) {
			slots.remove(slotId);
			return;
		}

		nextSection.processPark(slotId);
	}

	protected void processUnPark(Integer slotId) {
		if (slotId >= lowestSlotNumber && slotId <= highestSlotNumber) {
			slots.add(slotId);
			return;
		}

		nextSection.processUnPark(slotId);
	}

	public abstract Slot processNextSlot();

}
