package com.bootecampdsdesafioum.demo.services.exceptions;

public class ClientNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClientNotFoundException(String msg) {
		super(msg);
	}

}
