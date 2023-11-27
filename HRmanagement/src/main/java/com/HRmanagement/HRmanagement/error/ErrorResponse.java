package com.HRmanagement.HRmanagement.error;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

	String message;

	int status;

	Boolean success;

	LocalDateTime time;

	List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.status = 404;
		this.success = Boolean.FALSE;
		this.time = LocalDateTime.now();
		this.details = details;
	}

}
