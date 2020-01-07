package com.demo.authenticate.services.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.demo.authenticate.model.AuthenticUser;
import com.demo.authenticate.resource.AuthenticUserRepo;
import com.demo.authenticate.services.AuthenticUserService;
@Service
public class AuthenticUserServiceImpl implements AuthenticUserService {
	
	@Autowired
	AuthenticUserRepo repo;

	@Override
	public boolean validateUser(AuthenticUser user) {
		List<AuthenticUser> users= repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(users==null || users.size()==0) return true;
		return false;
	}

	@Override
	public void createNewUser(AuthenticUser user) {
		repo.save(user);
		
	}

	@Override
	public void updateUser(AuthenticUser user) {
		repo.save(user);
		
	}

	@Override
	public AuthenticUser validateUserLogin(HttpServletRequest request) {
		String username= request.getParameter("username");
		String password =  request.getParameter("password");
		List<AuthenticUser> users= repo.findByUsernameAndPassword(username,password );
	     return users.get(0);
	}
	


}
