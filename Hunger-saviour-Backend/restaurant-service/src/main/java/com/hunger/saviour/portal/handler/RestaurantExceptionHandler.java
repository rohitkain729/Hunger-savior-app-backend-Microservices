package com.hunger.saviour.portal.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException runtimeException) {
		
		return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
