package com.HRmanagement.HRmanagement.security;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.HRmanagement.HRmanagement.entities.Employees;
import com.HRmanagement.HRmanagement.entities.Token;
import com.HRmanagement.HRmanagement.repositories.TokenRepo;
import com.HRmanagement.HRmanagement.services.Employee_service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class jwtAuthFilter extends OncePerRequestFilter {

	private final JWTservice jwtService;

	private final TokenRepo tokenRepo;

	private final UserDetailsService userDetailsService;

	Logger log = LoggerFactory.getLogger(Employee_service.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail;

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		jwt = authHeader.substring(7);
		userEmail = jwtService.extraectUsername(jwt);

		Optional<Token> tok = tokenRepo.findByToken(jwt);

		log.info(tok.toString());

		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			Employees employee = (Employees) this.userDetailsService.loadUserByUsername(userEmail);

			var isTokenValid = tokenRepo.findByToken(jwt).map(t -> !t.isExpired() && !t.isRevoked()).orElse(false);

			if (jwtService.IsTokenValid(jwt, employee) && isTokenValid) {

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(employee, null,
						employee.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);

			}

		}

		filterChain.doFilter(request, response);

	}

}
