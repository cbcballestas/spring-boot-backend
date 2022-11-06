package com.example.demo.util;

import java.util.Objects;

public class StudentUtil {

	private StudentUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Verify if new value is different than old value
	 * 
	 * @param oldValue
	 * @param newValue
	 * @return true if new value is different than old value,otherwise false
	 */
	public static boolean isDifferent(String oldValue, String newValue) {
		return newValue != null && newValue.length() > 0 && !Objects.equals(oldValue, newValue);
	}

}
