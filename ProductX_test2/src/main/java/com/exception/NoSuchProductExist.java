package com.exception;

public class NoSuchProductExist extends RuntimeException{

	private String msg;

	public NoSuchProductExist(String msg) {
		super(msg);
		this.msg = msg;
	}

}
