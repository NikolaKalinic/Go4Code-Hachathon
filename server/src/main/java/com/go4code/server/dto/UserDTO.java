package com.go4code.server.dto;

import javax.persistence.Column;

import com.go4code.server.model.User;


public class UserDTO {
	
	private Long id;
    private String username;
    private String email;
    private String password;
    
    public UserDTO(){}

    public UserDTO(Long id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO( String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
