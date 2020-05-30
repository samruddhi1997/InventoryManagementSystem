package com.capgemini.inventorymanagementsystem.exception;

public class UserNotfoundException extends RuntimeException {
	String msg = "Enter valid user id,type or password";

	public void UserNotFoundException() {

	}

	@Override
	public String getMessage() {
		return msg;

	}
}
