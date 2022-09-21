package com.kieu.schoolorganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kieu.schoolorganizer.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
}