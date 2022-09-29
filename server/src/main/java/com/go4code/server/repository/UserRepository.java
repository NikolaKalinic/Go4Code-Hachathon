package com.go4code.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.go4code.server.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String userName);
	public User findByPassword(String password);

}
