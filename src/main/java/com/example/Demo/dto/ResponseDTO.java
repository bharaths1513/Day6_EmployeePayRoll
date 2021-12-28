package com.example.Demo.dto;

import lombok.Data;

public @Data class ResponseDTO {
	private String message;
	private Object data;

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

}