package com.codingdojo.doctor.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="posts")
public class Post {
	    @Id
	    @GeneratedValue
	    private Long id;
	    
	    @NotEmpty(message="Title is required!")
	    @Size(min=3, message="Title must be greater than 3 characters")
	    private String title;
	    
	    @NotEmpty(message="Description is required!")
	    @Size(min=3, message="Description must be g	reater than 3 characters")
	    private String description;
	    
	    @Size(min=3, message="Location must be greater than 3 characters")
	    private String location;
	    
	    @NotEmpty(message="Category is required!")
	    @Size(min=4, message="Category must be greater than 4 characters")
	    private String category;
	    
	    private String photo;
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @PrePersist
	    protected void onCreate(){
	    	this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	    	this.updatedAt = new Date();
	    }
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    @OneToMany(mappedBy="commentPost", fetch = FetchType.LAZY)
	    private List<Comment> postComments;

		public Post(Long id, String title, String description, String location, String category, String photo, User user, List<Comment> postComments) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.location = location;
			this.category = category;
			this.photo = photo;
			this.user = user;
			this.postComments = postComments;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
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
		public List<Comment> getPostComments() {
			return postComments;
		}
		public void setPostComments(List<Comment> postComments) {
			this.postComments = postComments;
		}
	    
	    
	    
}
