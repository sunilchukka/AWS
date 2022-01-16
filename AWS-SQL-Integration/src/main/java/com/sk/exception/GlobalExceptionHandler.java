package com.sk.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
 // handler specific Exceptions 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException rs, WebRequest request){
		ErrorDetails error=new ErrorDetails(new Date(), rs.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGenericExceptions(Exception ex, WebRequest request){
		ErrorDetails error=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
