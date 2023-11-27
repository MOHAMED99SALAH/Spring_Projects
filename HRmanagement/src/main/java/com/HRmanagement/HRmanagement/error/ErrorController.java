package com.HRmanagement.HRmanagement.error;

import java.lang.reflect.Array;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<?> recordNotFound(RecordNotFound ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<?> entityNotFound(EntityNotFound ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(passwordErrors.class)
	public ResponseEntity<?> passwordError(passwordErrors ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		List<String> errors = new ArrayList();

		for (FieldError er : ex.getBindingResult().getFieldErrors()) {
			errors.add(er.getDefaultMessage());
		}

		for (ObjectError er : ex.getBindingResult().getGlobalErrors()) {
			errors.add(er.getDefaultMessage());
		}

		ErrorResponse error = new ErrorResponse(ex.toString(), errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
