package com.kieu.tvdb.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Range(min=1, max=5, message = "between 1 to 5")
    private int rating;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User ratedBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tv_id")
    private Tv ratedTv;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	
	
	public Rating() {

	}



	public Rating(Long id, int rating, User ratedBy, Tv ratedTv,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.rating = rating;
		this.ratedBy = ratedBy;
		this.ratedTv = ratedTv;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public User getRatedBy() {
		return ratedBy;
	}



	public void setRatedBy(User ratedBy) {
		this.ratedBy = ratedBy;
	}



	public Tv getRatedTv() {
		return ratedTv;
	}



	public void setRatedTv(Tv ratedTv) {
		this.ratedTv = ratedTv;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
	
	
	
	