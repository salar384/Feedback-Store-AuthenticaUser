package com.demo.authenticate.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authenticate.model.AuthenticUser;
import com.demo.authenticate.services.AuthenticUserRestService;

@RestController
@RequestMapping("/users")
public class AuthenticUserRestController {

	@Autowired
	AuthenticUserRestService service;

	@PostMapping("/saveUser")
	public Long save(@RequestBody AuthenticUser user) {
		Long userId = service.save(user);
		return userId;
	}

	@DeleteMapping("/deleteUser/{userId}")
	public Long delete(@PathVariable("userId") Long userId) {
		service.delete(userId);
		return userId;
	}

	@PutMapping("/updateUser")
	public AuthenticUser update(@RequestBody AuthenticUser user) {
		AuthenticUser updateduser = service.update(user);
		return updateduser;
	}

	@GetMapping("/getUser/{userId}")
	public AuthenticUser get(@PathVariable("userId") Long userId) {
		AuthenticUser user = service.get(userId);
	if (user==null) return new AuthenticUser();
		return user;
	}

	@GetMapping("/getAllUsers")
	public List<AuthenticUser> getAllUsers() {
		List<AuthenticUser> users = service.getAll();
		return users;
	}
}
