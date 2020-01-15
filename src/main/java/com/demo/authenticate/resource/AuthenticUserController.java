package com.demo.authenticate.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.authenticate.model.AuthenticUser;
import com.demo.authenticate.services.AuthenticUserService;

@Controller
@RequestMapping("/users")
public class AuthenticUserController {
	@Autowired
	AuthenticUserService service;
	
	public ModelAndView createuser(AuthenticUser user) {
		
		ModelAndView view = new ModelAndView();
		
		return view;
		
		
	}
	
	@GetMapping("/login")
	public ModelAndView LoginUser(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("WelcomeUser");
		AuthenticUser user=service.validateUserLogin(request);
		if (user==null) {
			view.setViewName("Errorpage");
			return view;
		}
		view.addObject("user", user);
		/* view.setViewName("WelcomeUser"); */
		return view;
	}
	
	@GetMapping
	public ModelAndView printLoginPage() {
		System.out.println("in PrintLoginPage method");
		return new ModelAndView("Login");
	}
	
	
}
