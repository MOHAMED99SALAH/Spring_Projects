package com.boot.delicyfood.error;

import java.lang.reflect.Array;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class errorController extends ResponseEntityExceptionHandler {

	
	
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<?> recordNotFound(RecordNotFound ex)
	{
		
		errorResponse error = new errorResponse(ex.getMessage(),Arrays.asList(ex.getMessage()));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	
	
	
	@ExceptionHandler(entityNotFound.class)
	public ResponseEntity<?> entityNotFound(entityNotFound ex)
	{
		
		errorResponse error = new errorResponse(ex.getMessage(),Arrays.asList(ex.getMessage()));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		List<String> errors =new ArrayList();
		
		
		for(FieldError er : ex.getBindingResult().getFieldErrors())
		{
			errors.add(er.getDefaultMessage());
		}
		
		for(ObjectError er : ex.getBindingResult().getGlobalErrors())
		{
			errors.add(er.getDefaultMessage());
		}
		
		errorResponse error = new errorResponse(ex.toString(),errors);
		
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

	
	
}
