package com.example.exceptions;

public class NoParkingLotException extends ParkingLotException {

	private static final long serialVersionUID = 424890456916752102L;

	public NoParkingLotException(String errorMessage) {
		super(errorMessage);
	}

}
