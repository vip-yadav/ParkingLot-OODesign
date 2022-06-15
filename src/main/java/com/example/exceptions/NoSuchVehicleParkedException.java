package com.example.exceptions;

public class NoSuchVehicleParkedException extends RuntimeException {

	private static final long serialVersionUID = 2616942461969707524L;

	public NoSuchVehicleParkedException(String errorMessage) {
		super(errorMessage);
	}

}
