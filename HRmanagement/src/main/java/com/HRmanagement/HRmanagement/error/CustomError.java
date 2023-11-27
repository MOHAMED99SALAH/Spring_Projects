package com.HRmanagement.HRmanagement.error;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomError extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

		Map<String, Object> ErrorAttributes = super.getErrorAttributes(webRequest, options);

		ErrorAttributes.put("success", Boolean.FALSE);
		ErrorAttributes.put("status", ErrorAttributes.get("status"));
		ErrorAttributes.put("errorMessage", ErrorAttributes.get("error"));
		ErrorAttributes.put("locale", webRequest.getLocale().toString());
		ErrorAttributes.put("details", Arrays.asList(ErrorAttributes.get("message")));
		ErrorAttributes.remove("error");
		ErrorAttributes.remove("path");

		return ErrorAttributes;
	}

}
