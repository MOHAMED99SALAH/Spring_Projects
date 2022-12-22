package com.mosalah.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	

	@Autowired
	DataSource dataSource ;
	
    @Autowired
	public void configuerGlobalSecurity(AuthenticationManagerBuilder auth ) throws Exception
	{ 
    	
    	
    	
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT  username, password, age, address FROM users WHERE username=?")
		.authoritiesByUsernameQuery("SELECT  username, role FROM user_role  WHERE username =?");
    	
    	
  // 	auth.inMemoryAuthentication().withUser("mo").password("1111").roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
    http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/","/*serve*/**").access("hasRole('USER')")
    .and().formLogin().loginPage("/login").permitAll();
    	
		
	}
 
 
    
    
}

