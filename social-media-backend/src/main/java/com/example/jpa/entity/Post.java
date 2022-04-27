package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//we created a Post class & assigning values
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int p_id;
	private String p_name;
	private int likes;
	private String comment;
//multiple post has one user & for that we use a manytoone relationship 
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id") // take a user_id as a foreign key by using a referce id
	@JsonIgnoreProperties("postlist") // use a json ignore property for avoiding a json error in postman
	private User user;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int p_id, String p_name, int like, String comment, User user) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.likes = like;
		this.comment = comment;
		this.user = user;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getLike() {
		return likes;
	}

	public void setLike(int like) {
		this.likes = like;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [p_id=" + p_id + ", p_name=" + p_name + ", like=" + likes + ", comment=" + comment + ", user="
				+ user + "]";
	}

}
