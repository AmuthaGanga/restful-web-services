package com.intern.restwebservices.restfulwebservices.user.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past(message = "Birth Date must be in the past")
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public User() {

	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
