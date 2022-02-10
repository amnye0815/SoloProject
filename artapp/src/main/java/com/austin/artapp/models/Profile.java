package com.austin.artapp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	Information in profile - but not required for login/registration.
	private Integer age;
	private String location;
	private String bio;
	private String media;
	
//	created and updated at:
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
//	relationships between tables in DB
	@OneToOne(mappedBy="profile", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<User> user;

public Profile() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getBio() {
	return bio;
}

public void setBio(String bio) {
	this.bio = bio;
}

public String getMedia() {
	return media;
}

public void setMedia(String media) {
	this.media = media;
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

public List<User> getUser() {
	return user;
}

public void setUser(List<User> user) {
	this.user = user;
}
	
}
