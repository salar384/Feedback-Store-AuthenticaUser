package com.demo.authenticate.resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.authenticate.model.AuthenticUser;


public interface AuthenticUserRepo extends JpaRepository<AuthenticUser, Long>{

	 @Query("SELECT user FROM USERS_TABLE user WHERE LOWER(p.username) = LOWER(:username) and LOWER(p.password) = LOWER(:password)")
	public List<AuthenticUser> findByUsernameAndPassword(@Param("username") String username, @Param ("password") String password);
}
