package com.example.exceptions;

public class ParkingLotException extends RuntimeException {

	private static final long serialVersionUID = -4892288032134218872L;

	public ParkingLotException(String errorMessage) {
		super(errorMessage);
	}

}
