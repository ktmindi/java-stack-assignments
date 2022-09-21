package com.kieu.schoolorganizer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kieu.schoolorganizer.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
	
	List<Address> findAll();
}