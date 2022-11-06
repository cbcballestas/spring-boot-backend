package com.example.demo.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repo.IGenericRepo;
import com.example.demo.service.ICRUD;
import com.example.demo.util.RestUtil;

public abstract class CRUDImpl<T, I> implements ICRUD<T, I> {

	protected abstract IGenericRepo<T, I> getRepo();

	@Override
	@Transactional
	public ResponseEntity<T> save(T object) {
		return new ResponseEntity<>(getRepo().save(object), HttpStatus.CREATED);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<T> update(I id, T object) {

		T searchedObject = RestUtil.checkFound(getRepo().findById(id), id);

		T updatedObject = getRepo().save(searchedObject);

		return ResponseEntity.ok(updatedObject);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<T>> getAllRecords() {
		return ResponseEntity.ok(getRepo().findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<T> getRecordById(I id) {

		T object = RestUtil.checkFound(getRepo().findById(id), id);

		return ResponseEntity.ok(object);
	}

	@Override
	@Transactional
	public ResponseEntity<Void> deleteById(I id) {

		RestUtil.checkFound(getRepo().findById(id), id);
		getRepo().deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
