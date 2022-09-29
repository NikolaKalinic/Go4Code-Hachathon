package com.go4code.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.go4code.server.model.Post;
import com.go4code.server.repository.PostRepository;

@Component
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findOne(Long id) {
		return postRepository.findById(id).get();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public void remove(Long id) {
		postRepository.deleteById(id);
	}

}
