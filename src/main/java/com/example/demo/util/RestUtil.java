package com.example.demo.util;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.example.demo.exception.GlobalException;

public class RestUtil {

	private RestUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Method what finds by id, if a resource exist in database
	 * @param <T> generic resource
	 * @param <I> generic id
	 * @param resourceOptional
	 * @param id
	 * @return
	 */
	public static <T, I> T checkFound(Optional<T> resourceOptional, I id) {
		if (resourceOptional.isEmpty()) {
			throw new GlobalException(String.format(HttpErrorMessageEnum.NO_EXIST_ITEM.getMessage(), id),
					HttpStatus.NOT_FOUND);
		}

		return resourceOptional.get();
	}

}
