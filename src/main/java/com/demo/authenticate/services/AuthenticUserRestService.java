package com.demo.authenticate.services;

import java.util.List;

import com.demo.authenticate.model.AuthenticUser;

public interface AuthenticUserRestService {

	public Long save(AuthenticUser user);
	public Long delete(Long userId);
	public AuthenticUser update(AuthenticUser user);
	public AuthenticUser get(Long userId);
	public List<AuthenticUser> getAll();
}
