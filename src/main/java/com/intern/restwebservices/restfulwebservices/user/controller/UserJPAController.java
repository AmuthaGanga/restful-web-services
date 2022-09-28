package com.intern.restwebservices.restfulwebservices.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.intern.restwebservices.restfulwebservices.user.dao.PostRepository;
import com.intern.restwebservices.restfulwebservices.user.dao.UserDaoService;
import com.intern.restwebservices.restfulwebservices.user.dao.UserRepository;
import com.intern.restwebservices.restfulwebservices.user.exception.UserNotFoundException;
import com.intern.restwebservices.restfulwebservices.user.model.Post;
import com.intern.restwebservices.restfulwebservices.user.model.User;

@RestController
public class UserJPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	
	  @GetMapping("/jpa/users/{id}") 
	  public EntityModel<User> retrieveUser(@PathVariable int id){ 
		  Optional<User> user = userRepository.findById(id);
		  if(user==null) {
			  throw new UserNotFoundException("id-" + id);
		  }
		  EntityModel<User> entityModel = EntityModel.of(user.get());
		  WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		  entityModel.add(linkToUsers.withRel("all-users"));
		return entityModel;
		}
	  
	 @PostMapping("/jpa/users")
	 public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// After creating the user, want to return a status CREATED and the new User id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	 }
	 
	 @DeleteMapping("/jpa/users/{id}") 
	  public void deleteUser(@PathVariable int id){ 
		 userRepository.deleteById(id);
		}
	 
	 @GetMapping("/jpa/users/{id}/posts")
		public List<Post> retrieveAllUsers(@PathVariable int id){
			Optional<User> userById = userRepository.findById(id);
			if(userById==null) {
				  throw new UserNotFoundException("id-" + id);
			  }
			return userById.get().getPosts();
		}
	 
	 @PostMapping("/jpa/users/{id}/posts")
	 public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable int id) {
		 Optional<User> userOptional = userRepository.findById(id);
			if(userOptional==null) {
				  throw new UserNotFoundException("id-" + id);
			  }
		 
		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		// After creating the user, want to return a status CREATED and the new User id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	 }
	 
}
