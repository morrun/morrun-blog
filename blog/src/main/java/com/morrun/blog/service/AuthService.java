package com.morrun.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.User;
import com.morrun.blog.dao.UserDao;
import com.morrun.blog.http.AuthenticationSuccessResponse;
import com.morrun.blog.http.Response;

@Service
public class AuthService {
	@Autowired
	private UserDao userDao;
	
	public Response checklogin(Authentication authentication) {
		if (authentication != null) {
			Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
			return response;
		} else {
			return new Response(false);
		}
	}
	
	public Response checkUser(String username) {
		User user = userDao.findByUsername(username);
		if (user == null || user.getUsername() == null) {
			return new Response(false);
		}
		return new Response(true);
	}
}
