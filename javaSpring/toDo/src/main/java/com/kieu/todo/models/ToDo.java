package com.kieu.todo.models;

import javax.persistence.Entity;

@Entity
@Table(name="todos")
public class ToDo {
	
	private int id;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	public ToDo() {

	}
	public ToDo(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	//we are going to use sessions to store data because we have not connected to a database yet
	
	
}
