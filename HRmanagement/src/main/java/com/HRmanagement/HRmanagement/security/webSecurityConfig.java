package com.HRmanagement.HRmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.HRmanagement.HRmanagement.repositories.emp_repository;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class webSecurityConfig {

	private final jwtAuthFilter Jwtfilter;

	private final JWTservice Jwtservice;

	private final emp_repository emprRepo;

	private final AuthenticationProvider authenticationProvider;

	private static final String[] WHITE_LIST_URL = { "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
			"/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security",
			"/swagger-ui/**", "/webjars/**", "/swagger-ui.html" };

	@Autowired
	@org.springframework.context.annotation.Lazy
	public webSecurityConfig(jwtAuthFilter jwtfilter, JWTservice jwtservice, emp_repository empRepo,
			AuthenticationProvider authenticationProvider) {

		super();
		this.Jwtfilter = jwtfilter;
		this.Jwtservice = jwtservice;
		this.emprRepo = empRepo;
		this.authenticationProvider = authenticationProvider;
	}

	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry -> registry.requestMatchers(WHITE_LIST_URL).permitAll()
						.requestMatchers("/depertment/**")
						.hasAnyAuthority(com.HRmanagement.HRmanagement.enums.Role.ADMIN.name())
						.requestMatchers("/employee/**").authenticated().requestMatchers("/auth/**").permitAll()
						.anyRequest().authenticated())
				.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(Jwtfilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> (emprRepo.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
