package com.HRmanagement.HRmanagement.services;

import java.util.HashMap;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.HRmanagement.HRmanagement.entities.Employees;
import com.HRmanagement.HRmanagement.entities.Token;
import com.HRmanagement.HRmanagement.enums.TokenType;
import com.HRmanagement.HRmanagement.models.LoginResponse;
import com.HRmanagement.HRmanagement.models.logoutResponse;
import com.HRmanagement.HRmanagement.models.successfull_login;
import com.HRmanagement.HRmanagement.repositories.TokenRepo;
import com.HRmanagement.HRmanagement.repositories.emp_repository;
import com.HRmanagement.HRmanagement.security.JwtServiceIMPL;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class authService {

	private final JwtServiceIMPL jwtService;

	private final AuthenticationManager authManager;

	private final Employee_service Employee_service;
	private final PasswordEncoder passEncoder;

	private final emp_repository emp_repository;

	private final TokenRepo tokenRepo;

	private final TokenRepo tokenRepository;

	private final Employee_service emp_service;

	public successfull_login register(@RequestBody @Valid Employees emp) {

		emp_service.insert(emp);

		return successfull_login.builder().message("registered successfully").build();
	}

	public LoginResponse Login(String username, String password) {

		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		var emp = emp_repository.findByUsername(username).orElseThrow();
		var token = jwtService.generateToken(emp.getUsername());
		var RefreshToken = jwtService.generateRefreshToken(new HashMap<>(), emp.getUsername());
		getUserValidTokens(emp);
		savedUserToken(emp, token);
		return LoginResponse.builder().accessToken(token).RefreshToken(RefreshToken).build();

	}

	public logoutResponse logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return logoutResponse.builder().message("logout - failed ").build();
		}
		jwt = authHeader.substring(7);
		var storedToken = tokenRepository.findByToken(jwt).orElse(null);
		if (storedToken != null) {
			storedToken.setExpired(true);
			storedToken.setRevoked(true);
			tokenRepository.save(storedToken);
			SecurityContextHolder.clearContext();
			return logoutResponse.builder().message(" logout Succfully ").build();

		}

		return logoutResponse.builder().message("logout  failed ").build();

	}

	public LoginResponse refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader("Authorization");
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return null;
		}
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extraectUsername(refreshToken);
		if (userEmail != null) {
			var user = emp_repository.findByUsername(userEmail).orElseThrow();
			if (jwtService.IsTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user.getUsername());
				getUserValidTokens(user);
				savedUserToken(user, refreshToken);

				return LoginResponse.builder().accessToken(accessToken).RefreshToken(refreshToken).build();

			}
		}
		return LoginResponse.builder().accessToken("Token Still valid ").RefreshToken("").build();
	}

	private void getUserValidTokens(Employees emp) {

		var allValidToken = tokenRepo.getAllvalidtokensByUser(emp.getId());

		if (allValidToken.isEmpty())
			return;

		allValidToken.forEach(t -> {

			t.revoked = true;
			t.expired = true;

		});

		tokenRepo.saveAll(allValidToken);

	}

	private void savedUserToken(Employees emp, String token) {
		var userToken = Token.builder().emp(emp).token(token).tokenType(TokenType.BEARER).revoked(false).expired(false)
				.build();
		tokenRepo.save(userToken);
	}

}
