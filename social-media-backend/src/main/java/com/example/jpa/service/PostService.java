package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.entity.Post;
//we built a buisness logic here for posts

@Component
public interface PostService {
	Post savePost(Post po);

	List<Post> getAllPost();

	Post getAnPost(int id);

	Post updatePost(Post po, int id);

	String deletePost(int id);
}
