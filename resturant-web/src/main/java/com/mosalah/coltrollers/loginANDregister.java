package com.mosalah.coltrollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mosalah.DAO.UserDAO;
import com.mosalah.models.user;

@Controller
public class loginANDregister {
	
	

	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	 
		return "login";
	}

	
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
	 
		return "register";
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerr(@RequestParam String emailR,@RequestParam String passR,@RequestParam String ageR,@RequestParam String addR) {
	 
		user user=new user();
		
		user.setUsername(emailR);
		user.setPassword(passR);
		user.setAge(ageR);
		user.setAddress(addR);
		
		userDAO.register(user);
		
		
		return "login";
	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
		}
		return "home";
	}
	
	
	

}
