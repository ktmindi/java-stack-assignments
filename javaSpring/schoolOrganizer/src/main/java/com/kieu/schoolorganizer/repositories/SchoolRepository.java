package com.kieu.schoolorganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kieu.schoolorganizer.models.School;

public interface SchoolRepository extends CrudRepository<School, Long> {
	
	List<School> findAll();
}