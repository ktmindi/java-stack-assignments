package com.kieu.schoolorganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kieu.schoolorganizer.models.Student;
import com.kieu.schoolorganizer.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public List<Student> all() {
		return this.repository.findAll();
	}
	
	public Student create(Student item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Student retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Student update(Student student) {
		return this.repository.save(student);
	}
	
	//beginning of project
	//public boolean setSchool(Long schoolId, Long studentId) {
	//	Student student = this.retrieve(studentId);
	//	student.setSchool(this.schoolService.retrieve(schoolId));
	//	this.update(student); //dont forget to save
		//return true;
	//}
	//beginning of project
	//public boolean unsetSchool(Long schoolId, Long studentId) {
	//	Student student = this.retrieve(studentId);
	//	student.setSchool(null);
	//	this.update(student); //dont forget to save
		//return true;
	//}
}