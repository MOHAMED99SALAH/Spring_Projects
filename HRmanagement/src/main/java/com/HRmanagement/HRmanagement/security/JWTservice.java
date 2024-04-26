package com.HRmanagement.HRmanagement.security;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.HRmanagement.HRmanagement.entities.Employee;

public interface JWTservice {

	UserDetailsService userDetailsService();

	String generateToken(String username);

	String generateRefreshToken(Map<String, Object> claims, String username);

	String extraectUsername(String token);

	Boolean IsTokenValid(String Token, Employee emp);

	Boolean IsTokenExpired(String Token);

}
