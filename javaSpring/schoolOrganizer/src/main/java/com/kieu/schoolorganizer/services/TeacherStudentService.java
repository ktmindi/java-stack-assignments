package com.kieu.schoolorganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kieu.schoolorganizer.models.TeacherStudent;
import com.kieu.schoolorganizer.repositories.TeacherStudentRepository;

@Service
public class TeacherStudentService {
	
	@Autowired
	private TeacherStudentRepository repository;
	
	
	public List<TeacherStudent> all() {
		return this.repository.findAll();
	}
	
	public TeacherStudent create(TeacherStudent item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public boolean delete(Long teacherId, Long studentId) {
		
		TeacherStudent teacherStudent = this.repository.findByTeacherIdAndStudentId(teacherId, studentId);
		
		if ( teacherStudent == null ) return false;
		
		this.delete(teacherStudent.getId());
		
		return true;
	}
	
	public TeacherStudent retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public TeacherStudent update(TeacherStudent teacherStudent) {
		return this.repository.save(teacherStudent);
	}
}