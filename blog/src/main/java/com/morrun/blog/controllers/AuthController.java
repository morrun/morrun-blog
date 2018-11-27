package com.morrun.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morrun.blog.http.Response;
import com.morrun.blog.service.AuthService;

@RestController
public class AuthController {
	@Autowired
	private AuthService authS;
	
	@PostMapping("/checkUser")
	public Response checkUserExist(@RequestBody String username) {
		return authS.checkUser(username);
	}
	@GetMapping("/checkLogin")
	public Response checklogin(Authentication authentication) {
		return authS.checklogin(authentication);
	}
}
