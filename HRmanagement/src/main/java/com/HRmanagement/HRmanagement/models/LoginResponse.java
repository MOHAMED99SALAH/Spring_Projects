package com.HRmanagement.HRmanagement.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

	private final String accessToken;

	private final String RefreshToken;

}
