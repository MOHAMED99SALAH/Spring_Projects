package com.HRmanagement.HRmanagement.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Configuration
@RequiredArgsConstructor
@Getter
@Setter
@ConfigurationProperties("security.jwt")
public class jwtProperties {

	private String secret_Key = "12359874569875632145897456321456987456321456987456321456321456336";
}
