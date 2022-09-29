package com.go4code.server.dto;

import com.go4code.server.model.User;

public class LoginDTO {
	
    private String username;
    private String password;
    
    public LoginDTO(){}

    public LoginDTO(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public LoginDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
