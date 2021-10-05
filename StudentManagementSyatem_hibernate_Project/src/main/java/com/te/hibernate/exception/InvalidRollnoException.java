package com.te.hibernate.exception;

public class InvalidRollnoException extends RuntimeException{
	String msg;
	public InvalidRollnoException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return this.msg;
	}


}
