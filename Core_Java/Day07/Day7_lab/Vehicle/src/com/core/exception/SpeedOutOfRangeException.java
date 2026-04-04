package com.core.exception;
@SuppressWarnings("serial")
public class SpeedOutOfRangeException extends Exception {
	public SpeedOutOfRangeException(String errorMesg) {
		super(errorMesg);
	}
}