package com.go4code.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.go4code.server.model.Comment;
import com.go4code.server.repository.CommentRepository;

@Component
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	
	public Page<Comment> findAll(Pageable page) {
		return commentRepository.findAll(page);
	}

	public Comment findOne(Long id) {
		return commentRepository.findById(id).get();
	}

	public Comment save(Comment exam) {
		return commentRepository.save(exam);
	}

	public void remove(Long id) {
		commentRepository.deleteById(id);
	}
	
	public List<Comment> findCommentsByPostId(Long id) {
		return commentRepository.findByPostId(id);
	}

}
