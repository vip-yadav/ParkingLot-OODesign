package com.example.strategy;

import com.example.models.slots.Slot;
import com.example.models.slots.SlotCategory;
import com.example.models.slots.VehicleCategory;

/*
 * NaturalOrderStrategy
 * initialize:
 *  first one third reserve for twoWheeler
 *  second one third reserve for compact vehicle
 *  third one third reserve for medium vehicle
 * 
 * also had waterfall model, means a two wheeler can park in 
 *
 */
public class NaturalOrderStrategy implements ParkingStrategy {

	private Section twoWheelarChain;
	private Section compactChain;
	private Section mediumChain;

	@Override
	public void initialize(int capacity) {
		this.mediumChain = new MediumSection(Math.floorDiv(2 * capacity, 3), capacity, null);
		this.compactChain = new CompactSection(Math.floorDiv(capacity, 3), Math.floorDiv(2 * capacity, 3) - 1,
				mediumChain);
		this.twoWheelarChain = new TwoWheelerSection(0, Math.floorDiv(capacity, 3) - 1, compactChain);
	}

	@Override
	public void addSlot(Integer slotId) {
		twoWheelarChain.processUnPark(slotId);

	}

	@Override
	public void removeSlot(Integer slotId) {
		twoWheelarChain.processPark(slotId);
	}

	@Override
	public Slot getNextSlot(VehicleCategory category) {
		if (category.getCategoryType().equals(SlotCategory.TwoWheeler.getCategoryType())) {
			return twoWheelarChain.processNextSlot();
		} else if (category.getCategoryType().equals(SlotCategory.Compact.getCategoryType())) {
			return compactChain.processNextSlot();
		} else if (category.getCategoryType().equals(SlotCategory.Medium.getCategoryType())) {
			return mediumChain.processNextSlot();
		}
		return null;
	}
}
