package com.demo.authenticate.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authenticate.model.AuthenticUser;
import com.demo.authenticate.resource.AuthenticUserRepo;
import com.demo.authenticate.services.AuthenticUserRestService;

@Service
public class AuthenticUserRestServiceImpl implements AuthenticUserRestService {

	@Autowired
	AuthenticUserRepo entityManager;

	@Override
	public Long save(AuthenticUser user) {
		AuthenticUser savedUser = entityManager.save(user);
		return savedUser.getId();
	}

	@Override
	public Long delete(Long userId) {
		entityManager.deleteById(userId);
		return userId;
	}

	@Override
	public AuthenticUser update(AuthenticUser user) {
		AuthenticUser updateduser = entityManager.save(user);
		return updateduser;
	}

	@Override
	public AuthenticUser get(Long userId) {
		Optional<AuthenticUser> opt=entityManager.findById(userId);
	if(opt.isPresent()) {
		AuthenticUser user =opt.get();
		return user;
	}
	return null;

	}

	@Override
	public List<AuthenticUser> getAll() {
		 List<AuthenticUser> users= entityManager.findAll();
		return users;
	}
}
