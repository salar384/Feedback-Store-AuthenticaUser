package com.demo.authenticate.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.authenticate.model.AuthenticUser;


public interface AuthenticUserRepo extends JpaRepository<AuthenticUser, Long>{

	@Query("select user from AuthenticUser user where user.username= ?1 and user.password= ?2 ")
	public List<AuthenticUser> findByUsernameAndPassword( String username, String password);
}
