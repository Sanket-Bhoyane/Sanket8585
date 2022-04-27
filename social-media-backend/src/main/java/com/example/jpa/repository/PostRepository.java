package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
