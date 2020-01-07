package com.demo.authenticate.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;

import com.demo.authenticate.model.AuthenticUser;

public interface AuthenticUserService {

	public boolean validateUser(AuthenticUser user);
	public void createNewUser(AuthenticUser user);
	 public void updateUser(AuthenticUser user);
	 public AuthenticUser validateUserLogin(HttpServletRequest request);
	 
	
}
