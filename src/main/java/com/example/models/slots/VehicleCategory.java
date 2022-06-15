package com.example.models.slots;

public enum VehicleCategory {
	TwoWheeler("TwoWheeler"), Compact("Compact"), Medium("Medium");

	String categoryType;

	VehicleCategory(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryType() {
		return this.categoryType;
	}
}
