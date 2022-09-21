package com.kieu.schoolorganizer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int grade;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //beginning of project -- 
    //@ManyToOne(fetch=FetchType.LAZY) //one school has many students
    //@JoinColumn(name="school_id")  //parent name_id 
    //private School school  //--- parent "mapped by"
    @OneToMany(mappedBy="student", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnore
    private List<TeacherStudent> teacherStudent;
    
    
	public List<TeacherStudent> getTeacherStudent() {
		return teacherStudent;
	}
	public void setTeacherStudent(List<TeacherStudent> teacherStudent) {
		this.teacherStudent = teacherStudent;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Student() {}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	 
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}