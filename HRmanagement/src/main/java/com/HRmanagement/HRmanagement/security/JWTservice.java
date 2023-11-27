package com.HRmanagement.HRmanagement.security;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.HRmanagement.HRmanagement.entities.Employees;

public interface JWTservice {

	UserDetailsService userDetailsService();

	String generateToken(String username);

	String generateRefreshToken(Map<String, Object> claims, String username);

	String extraectUsername(String token);

	Boolean IsTokenValid(String Token, Employees emp);

	Boolean IsTokenExpired(String Token);

}
