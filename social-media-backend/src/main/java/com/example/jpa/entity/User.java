package com.example.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//we created a Post class & assigning values

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int follwer;
	private String gender;
	// one user has multiple posts & for that we use a one to many relationship

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user") // use a json ignore property for avoiding a json error in postman
	private List<Post> postlist;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, int follwer, String gender, List<Post> postlist) {
		super();
		this.id = id;
		this.name = name;
		this.follwer = follwer;
		this.gender = gender;
		this.postlist = postlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollwer() {
		return follwer;
	}

	public void setFollwer(int follwer) {
		this.follwer = follwer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Post> getPostlist() {
		return postlist;
	}

	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}

}
