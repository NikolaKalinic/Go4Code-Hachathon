package com.go4code.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.go4code.server.model.Comment;


@Component
public interface CommentRepository extends JpaRepository<Comment, Long>{
	public List<Comment> findByPostId(Long id);

}
