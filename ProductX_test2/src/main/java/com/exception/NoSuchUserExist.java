package com.exception;

public class NoSuchUserExist extends RuntimeException {

	private String msg;

	public NoSuchUserExist(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
