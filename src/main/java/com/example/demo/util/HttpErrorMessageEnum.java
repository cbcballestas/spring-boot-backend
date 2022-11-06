package com.example.demo.util;

import lombok.Getter;

@Getter
public enum HttpErrorMessageEnum {
	NO_EXIST_ITEM("Record with ID %d does not exists");

	private String message;

	private HttpErrorMessageEnum(String message) {
		this.message = message;
	}

}
