package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Post;
import com.example.jpa.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping(value = "/savepost")
	public Post savePost(@RequestBody Post po) {
		return postService.savePost(po);

	}

	@GetMapping(value = "/getallpost")
	public List<Post> getAnPost() {
		return postService.getAllPost();

	}

	@GetMapping(value = "/post/{id}")
	public Post getAnPost(@PathVariable int id) {
		return postService.getAnPost(id);

	}

	@PutMapping(value = "/post/{id}")
	public Post updateAnPost(@PathVariable int id, @RequestBody Post po) {

		return postService.updatePost(po, id);

	}

	@DeleteMapping(value = "/post/{id}")
	public String deleteAnPost(@PathVariable int id) {

		return postService.deletePost(id);

	}

}
