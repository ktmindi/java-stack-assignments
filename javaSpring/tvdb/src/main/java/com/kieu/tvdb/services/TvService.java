package com.kieu.tvdb.services;

import java.util.List;
//import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.validation.Errors;

import com.kieu.tvdb.models.Rating;
import com.kieu.tvdb.models.Tv;
import com.kieu.tvdb.repositories.RatingRepository;
import com.kieu.tvdb.repositories.TvRepository;
//import com.kieu.tvdb.repositories.UserRepository;




@Service
public class TvService {
	@Autowired
	private TvRepository tRepo;
	//@Autowired
	//private UserRepository usRepo;
	@Autowired
	private RatingRepository rRepo;
	
	//standard CRUD services needed
	
	//validate title of tvshow must be unique
	//public void validT(Tv newTv, Errors errors) {
	//	if(tRepo.findByTitle(newTv.getTitle())!=null) {
	//		errors.rejectValue("title", "unique", "title is already taken");
	//	}
	//}
	
	
	//list all tv shows
	public List<Tv> allTvs() {
		return tRepo.findAll();
	}
	//public List<Tv> ascOrder() {
	//	return tRepo.findAll(Set.by(Sort.Direction.ASC, "ratings"));
	//}
	//create new tv show post
	public Tv addTv(Tv tv) {
		return tRepo.save(tv);
	}
	
	//delete a  tv show post
	public void deleteTv(Long id) {
		tRepo.deleteById(id);
	}
	
	//get one tv show by id
	public Tv getOneTv(Long id) {
		return tRepo.findById(id).orElse(null);
	}
	
	//update a tv show post
	public Tv updateTv(Tv tv) {
		return tRepo.save(tv);
	}
	
	//add rating
	public void createRating(Rating newRating) {
		rRepo.save(newRating);
	}
	
	//these additional methods can be placed in either of the service files 
	//business logic doesnt change
	//like
	

	//public void likeBook(Book book, User user) {
	//	List<User> likers = book.getLikers();
	//	likers.add(user);
	//	bRepo.save(book);
		
	//}
	
	//unlike
	//public void unlikeBook(Book book, User user) {
	//	List<User> likers = book.getLikers();
	//	likers.remove(user);
	//	bRepo.save(book);
		
	//}
}
