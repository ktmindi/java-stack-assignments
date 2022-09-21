package com.kieu.tvdb.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kieu.tvdb.models.Tv;


@Repository
public interface TvRepository extends CrudRepository<Tv, Long> {
	List<Tv> findAll();
	//List<Tv> findAllByOrderByRatings(Float ratings);
	
}
