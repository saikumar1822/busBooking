package com.learn.busBooking.exception;

public class BusNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public BusNotFoundException(String string) {
		super(string);
	}

}
