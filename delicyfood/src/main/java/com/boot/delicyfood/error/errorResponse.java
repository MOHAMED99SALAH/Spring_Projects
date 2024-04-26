package com.boot.delicyfood.error;

import java.time.LocalDateTime;
import java.util.List;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
