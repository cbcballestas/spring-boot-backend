package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public GlobalException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public GlobalException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
