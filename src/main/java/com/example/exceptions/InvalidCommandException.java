package com.example.exceptions;

import java.io.IOException;

/*
 * InvalidCommandException
 */
public class InvalidCommandException extends IOException {
	private static final long serialVersionUID = -5478066115687322651L;

	public InvalidCommandException(String errorMessage) {
		super(errorMessage);
	}

}
