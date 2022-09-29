package com.go4code.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.go4code.server.model.Post;


@Component
public interface PostRepository extends JpaRepository<Post, Long>{

}
