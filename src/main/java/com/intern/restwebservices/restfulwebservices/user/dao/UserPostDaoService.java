package com.intern.restwebservices.restfulwebservices.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intern.restwebservices.restfulwebservices.user.model.UserPost;

@Component
public class UserPostDaoService {
	
	private static int postsCount = 3;
	
	private static List<UserPost> userPosts = new ArrayList<>();
	static {
		userPosts.add(new UserPost(1, 1, "About Hogwarts", "A place where I belong!!"));
		userPosts.add(new UserPost(2, 1, "Socerers stone", "To give Immortality!!"));
		userPosts.add(new UserPost(3, 1, "Quidditch", "An exhilarating experience!!"));
		userPosts.add(new UserPost(1, 2, "Harry Potter", "My best friend!"));
		userPosts.add(new UserPost(2, 3, "Magical School", "Whole new experience where I can excel"));
	}
	
	public List<UserPost> findAll(){
		return userPosts;
	}
	
	public List<UserPost> findAllPostsForUser(int id){
		List<UserPost> posts = new ArrayList<UserPost>();
		for(UserPost post:userPosts) {
			if(post.getUserId() == id) {
				posts.add(post);
			}
		}
		return posts;
	}
	
	public UserPost findOneUserPost(int id, int post_id) {
		for(UserPost post:userPosts) {
			if(post.getPostId() == post_id && post.getUserId() == id) {
				return post;
			}
		}
		return null;
	}
	
	public UserPost save(UserPost post) {
		System.out.println("In post dao service --> " +post);
		if(post.getPostId() == null) {
			post.setPostId(++postsCount);
			System.out.println("Inside if clause --> " +post);
		}
		userPosts.add(post);
		System.out.println("Altered userPosts --> " +userPosts);
		return post;
	}
	
	public UserPost findOne(int id) {
		for(UserPost post:userPosts) {
			if(post.getPostId() == id) {
				return post;
			}
		}
		return null;
	}

}
