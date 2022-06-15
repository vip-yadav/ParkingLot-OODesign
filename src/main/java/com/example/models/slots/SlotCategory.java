package com.example.models.slots;

public enum SlotCategory {
	TwoWheeler("TwoWheeler"), Compact("Compact"), Medium("Medium");

	String categoryType;

	SlotCategory(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryType() {
		return this.categoryType;
	}
}
