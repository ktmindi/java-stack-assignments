package com.kieu.tvdb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tvs")
public class Tv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 5, max = 200, message="title must be unique")
	private String title;
	@NotBlank
	@Size(min = 5, max = 200, message="network must contain at least 5 characters")
	private String network;
	@NotBlank
	@Size(min = 3, max = 500, message="summary must contain at least 3 characters")
	private String summary;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	// define the relationship user_id is the column that will be created in our table "books"
	//private user must = mappedBy in other file 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	//manytomany having no extra entities
	//@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(
	//		name = "likes",
	//		joinColumns = @JoinColumn(name = "book_id"),
	//		inverseJoinColumns = @JoinColumn(name = "user_id")
	//)
	//private List<User> likers;
	@OneToMany(mappedBy="ratedTv", fetch=FetchType.LAZY)
	private List<Rating> ratings;
	

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Tv() {
		super();
	}
	public Tv(Long id, String title, String network, String summary, Date createdAt, Date updatedAt, User user, List<Rating> ratings) {
		this.id = id;
		this.title = title;
		this.network = network;
		this.summary = summary;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.ratings = ratings;
	}
	//get the average of the ratings for the home page 
	public float getAve() {
		float sum=0;
		for(Rating rating:ratings) {
			sum+=rating.getRating();
		}
		if(sum!=0 ) {
			sum=sum/ratings.size();
			return sum;
		}
		else {
			return 1.0f;
		}
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
    
   
}
