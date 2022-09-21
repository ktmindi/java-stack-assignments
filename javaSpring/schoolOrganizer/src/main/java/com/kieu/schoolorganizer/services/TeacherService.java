package com.kieu.schoolorganizer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kieu.schoolorganizer.models.Student;
import com.kieu.schoolorganizer.models.Teacher;
import com.kieu.schoolorganizer.models.TeacherStudent;
import com.kieu.schoolorganizer.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherStudentService teacherStudentService;
	
	
	public List<Teacher> all() {
		return this.repository.findAll();
	}
	
	public Teacher create(Teacher item) {
		return this.repository.save(item);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Teacher retrieve(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Teacher update(Teacher Teacher) {
		return this.repository.save(Teacher);
	}
	
	public boolean setSchool(Long schoolId, Long teacherId) {
		
		Teacher teacher = this.retrieve(teacherId);
		
		teacher.setSchool(this.schoolService.retrieve(schoolId));
		
		this.update(teacher); // don't forget to save!
		
		return true;
	}
	
	public boolean unsetSchool(Long schoolId, Long teacherId) {
		
		Teacher teacher = this.retrieve(teacherId);
		
		teacher.setSchool(null);
		
		this.update(teacher); // don't forget to save!
		
		return true;
		
	}
	
	public TeacherStudent attachStudent(Long teacherId, Long studentId) {
		
		Teacher teacher = this.retrieve(teacherId);
		Student student = this.studentService.retrieve(studentId);
		
		if ( teacher == null || student == null ) return null;
		
		return this.teacherStudentService.create(new TeacherStudent(teacher, student));
	}
	
	public boolean detachStudent(Long teacherId, Long studentId) {
		
		Teacher teacher = this.retrieve(teacherId);
		Student student = this.studentService.retrieve(studentId);
		
		if ( teacher == null || student == null ) return false;
		
		this.teacherStudentService.delete(teacherId, studentId);
		
		return true;
	}
}