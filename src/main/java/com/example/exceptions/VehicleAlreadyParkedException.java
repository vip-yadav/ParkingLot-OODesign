package com.example.exceptions;

public class VehicleAlreadyParkedException extends RuntimeException{
	
	private static final long serialVersionUID = -5039359903590729289L;

	public VehicleAlreadyParkedException(String errorMessage) {
		super(errorMessage);
	}
	

}
