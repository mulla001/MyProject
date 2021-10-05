package com.te.hibernate.exception;

public class InvaidInputProvided extends RuntimeException{
	String msg;
	public InvaidInputProvided(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return this.msg;
	}
	

}
