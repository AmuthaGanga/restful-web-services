package com.intern.restwebservices.restfulwebservices.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.intern.restwebservices.restfulwebservices.user.dao.UserPostDaoService;
import com.intern.restwebservices.restfulwebservices.user.exception.PostNotFoundException;
import com.intern.restwebservices.restfulwebservices.user.model.UserPost;

@RestController
public class PostResource {
	
	@Autowired
	private UserPostDaoService postDaoService;
	
	public PostResource(UserPostDaoService postDaoService) {
		this.postDaoService = postDaoService;
	}
	
	@GetMapping("/posts")
	public List<UserPost> retrieveAllPosts(){
		return postDaoService.findAll();
	}
	
	@GetMapping("/posts/{id}") 
	  public UserPost retrieveUser(@PathVariable int id){ 
		  UserPost post = postDaoService.findOne(id);
		  if(post==null) {
			  throw new PostNotFoundException("id-" + id);
		  }
		return post;
		}

	@GetMapping("/users/{id}/posts")
	public List<UserPost> retrieveAllPostsOfUser(@PathVariable int id){
		return postDaoService.findAllPostsForUser(id);
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public UserPost retrievePostOfUser(@PathVariable int id,@PathVariable int post_id){
		return postDaoService.findOneUserPost(id, post_id);
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createUserPost(@PathVariable int id, @RequestBody UserPost post) {
		post.setUserId(id);
		System.out.println("post details before save --> " +post);
		UserPost newPost = postDaoService.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(newPost.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
