package com.kieu.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kieu.dojosandninjas.models.Dojo;
import com.kieu.dojosandninjas.models.Ninja;
import com.kieu.dojosandninjas.repositories.DojoRepository;
import com.kieu.dojosandninjas.repositories.NinjaRepository;

@Service
public class MainService {
	@Autowired
	private DojoRepository doRe;
	
	@Autowired
	private NinjaRepository niRe;
	
	//public MainService(DojoRepository doRe) {
	//	this.doRe = doRe;
	//}
	
	//public MainService(NinjaRepository niRe) {
	//	this.niRe = niRe;
	//}
	
	
	//read
	public List<Dojo> allDojo() {
		return this.doRe.findAll();
	}
	
	public List<Ninja> allNinja() {
		return this.niRe.findAll();
	}
	
	public List<Ninja> byDojo(Dojo dojo) {
		return niRe.findAllByDojo(dojo);
	}
	
	//create
	public Dojo addDojo(Dojo dojo) {
		return this.doRe.save(dojo);
	}
	
	public Ninja addNinja(Ninja ninja) {
		return this.niRe.save(ninja);
	}
	
	//get by ID
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> result = this.doRe.findById(id);
		if(result.isPresent() ) {
			return result.get();
		} else {
			return null;
		}
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> result = niRe.findById(id);
		if(result.isPresent() ) {
			return result.get();
		} else {
			return null;
		}
	}
	
	
	
}
