package com.kieu.schoolorganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kieu.schoolorganizer.models.TeacherStudent;

public interface TeacherStudentRepository extends CrudRepository<TeacherStudent, Long> {
	
	List<TeacherStudent> findAll();
	
	TeacherStudent findByTeacherIdAndStudentId(Long teacherId, Long studentId);
}