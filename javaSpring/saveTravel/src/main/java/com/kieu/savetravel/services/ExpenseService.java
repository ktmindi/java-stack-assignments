package com.kieu.savetravel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kieu.savetravel.models.Expense;
import com.kieu.savetravel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	//always remember to add the repository as a dependency
	@Autowired
	private ExpenseRepository expRepo;
	
	//public ExpenseService(ExpenseRepository expRepo) {
	//	this.expRepo = expRepo;
	//}
	
	//from here we write methods to wrap our repository CRUD
	

	//read
	public List<Expense> all() {
		return this.expRepo.findAll();
	}
	
	//create
	public Expense add(Expense exp) {
		return expRepo.save(exp);
	}
	
	//update
	public Expense update(Expense exp) {
		return this.expRepo.save(exp);
	}
	
	//delete
	public void delete(Long id) {
		this.expRepo.deleteById(id);
	}

	
	//get an expense by id for show page
	public Expense find(Long id) {
		return this.expRepo.findById(id).get();
	}
}


