package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICRUD<T, I> {

	ResponseEntity<T> save(T object);

	ResponseEntity<T> update(I id, T object);

	ResponseEntity<List<T>> getAllRecords();

	ResponseEntity<T> getRecordById(I id);

	ResponseEntity<Void> deleteById(I id);

}
