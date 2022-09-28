package com.intern.restwebservices.restfulwebservices.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.restwebservices.restfulwebservices.user.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
