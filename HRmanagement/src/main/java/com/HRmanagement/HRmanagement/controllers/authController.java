package com.HRmanagement.HRmanagement.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.HRmanagement.HRmanagement.entities.Employees;
import com.HRmanagement.HRmanagement.models.LoginRequest;
import com.HRmanagement.HRmanagement.models.LoginResponse;
import com.HRmanagement.HRmanagement.models.logoutResponse;
import com.HRmanagement.HRmanagement.models.successfull_login;
import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {

	private final com.HRmanagement.HRmanagement.services.authService authService;

	
	@Operation(summary = " create a user ")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public successfull_login register(@RequestBody @Valid Employees emp) {
		return authService.register(emp);
	}

	@Operation(summary = " login the  user ")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody @Validated LoginRequest request) {

		return authService.Login(request.getEmail(), request.getPassword());

	}
	@Operation(summary = "refresh Token ")
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public LoginResponse refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return authService.refreshToken(request, response);

	}
	@Operation(summary = " logout the  user ")
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public logoutResponse logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		return authService.logout(request, response);

	}

}