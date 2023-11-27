package com.HRmanagement.HRmanagement.security;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.HRmanagement.HRmanagement.entities.Employees;
import com.HRmanagement.HRmanagement.services.Employee_service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtServiceIMPL implements JWTservice {

	private final jwtProperties jwtprop;

	private final Employee_service emp_service;

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				Employees emp = emp_service.findByusername(username);

				return emp;
			}
		};
	}

	@Override
	public String generateToken(String username)

	{
		return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 86400000 * 2))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();

	}

	@Override
	public String generateRefreshToken(Map<String, Object> claims, String username)

	{
		return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 604800000))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	@Override
	public String extraectUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimResolvers) {
		final Claims claims = extractAllClaim(token);
		return claimResolvers.apply(claims);

	}

	private Claims extractAllClaim(String token) {

		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();

	}

	private Key getKey() {

		byte[] key = Decoders.BASE64.decode(jwtprop.getSecret_Key());
		return Keys.hmacShaKeyFor(key);
	}

	@Override
	public Boolean IsTokenValid(String Token, Employees emp) {
		final String username = extraectUsername(Token);
		return (username.equals(emp.getUsername()) && !IsTokenExpired(Token));
	}

	@Override
	public Boolean IsTokenExpired(String Token) {
		return extractClaim(Token, Claims::getExpiration).before(new Date());
	}

}