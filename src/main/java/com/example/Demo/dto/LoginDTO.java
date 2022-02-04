package com.example.Demo.dto;

import lombok.Data;
import lombok.ToString;

@ToString
public @Data class LoginDTO {
	public String password;
	public String emailid;
	}
