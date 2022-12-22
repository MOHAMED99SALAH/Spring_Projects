package com.mosalah.coltrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	
	
	
	@ExceptionHandler(value=Exception.class)
	public  String handler (HttpServletRequest request ,Exception ex)
	{
	
		return "error";
		
	}
	
}
