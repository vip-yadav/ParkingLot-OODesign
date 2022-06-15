package com.example.helper;

public class IntegerValidator {
	public static boolean isInteger(final String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
