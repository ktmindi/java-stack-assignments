package com.kieu.authentification.repositories;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kieu.authentification.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
	//when would we use <Optional> User versus User ?
}
