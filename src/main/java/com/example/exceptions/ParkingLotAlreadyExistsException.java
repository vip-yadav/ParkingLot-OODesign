package com.example.exceptions;

public class ParkingLotAlreadyExistsException extends ParkingLotException {

	private static final long serialVersionUID = 185414199840954478L;

	public ParkingLotAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
