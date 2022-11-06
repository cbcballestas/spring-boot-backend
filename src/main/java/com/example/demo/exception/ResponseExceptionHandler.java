package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResponseExceptionHandler {

	/**
	 * Method which handle all exceptions and return an error response
	 * @param exception
	 * @param request
	 * @return ErrorResponse object
	 */
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException exception, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(error, exception.getStatus());
	}

}
