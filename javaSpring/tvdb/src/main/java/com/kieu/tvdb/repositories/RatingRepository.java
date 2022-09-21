package com.kieu.tvdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kieu.tvdb.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{


}
