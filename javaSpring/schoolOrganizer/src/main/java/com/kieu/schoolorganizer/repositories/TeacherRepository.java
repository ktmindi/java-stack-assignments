package com.kieu.schoolorganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kieu.schoolorganizer.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	
	List<Teacher> findAll();
}