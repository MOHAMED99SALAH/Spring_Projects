package com.HRmanagement.HRmanagement.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class passwordRequest {

	private final String currentPassword;

	private final String newPassword;

	private final String confirmedPassword;

}
