package com.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource not found on serve!!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
