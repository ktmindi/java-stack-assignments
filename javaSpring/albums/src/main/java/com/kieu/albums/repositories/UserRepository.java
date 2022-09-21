package com.kieu.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kieu.albums.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll(); // SELECT * FROM users
}
