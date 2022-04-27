package com.example.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Post;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.service.PostService;

//we use a crude operation here for posts
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postRepository;

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post getAnPost(int id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " Not Found!!!!!"));
	}

	@Override
	public Post updatePost(Post post, int id) {
		Post p = postRepository.findById(id).get();
		p.setP_name(post.getP_name());
		p.setLike(post.getLike());
		p.setComment(post.getComment());
		return postRepository.save(p);
	}

	@Override
	public String deletePost(int id) {
		postRepository.deleteById(id);
		return "Post with id " + id + " has been deleted!!!!";

	}
}
