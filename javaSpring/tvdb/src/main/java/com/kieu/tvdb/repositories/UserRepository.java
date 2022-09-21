package com.kieu.tvdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kieu.tvdb.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
	//when would we use <Optional> User versus User ?
	//we dont need to add anything to repository to add on likes

}
