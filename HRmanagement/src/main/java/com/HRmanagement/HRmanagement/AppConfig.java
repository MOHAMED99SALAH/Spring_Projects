package com.HRmanagement.HRmanagement;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableCaching
@EnableJpaAuditing(auditorAwareRef = "auditoraware")
public class AppConfig {

	
	
	@Bean
	public AuditorAware<String> auditoraware(){
		
		return new AuditorAwareImpl();
		
	}
	
	
}
