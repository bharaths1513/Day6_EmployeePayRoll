package com.example.Demo.dto;

import lombok.Data;

public @Data class response {
	private Object data;

	public response(Object data) {
		
		this.data = data;
	}
	
	
	
	
}
