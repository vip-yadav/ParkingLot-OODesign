package com.example.exceptions;

public class NoSlotException extends RuntimeException{
	
	private static final long serialVersionUID = 8540273832282406277L;

	public NoSlotException(String errorMessage) {
		super(errorMessage);
	}

}
