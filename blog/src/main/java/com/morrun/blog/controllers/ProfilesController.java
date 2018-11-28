package com.morrun.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morrun.blog.beans.Profiles;
import com.morrun.blog.http.Response;
import com.morrun.blog.service.ProfilesService;

@RestController
public class ProfilesController {

	@Autowired
	private ProfilesService ps;
	
	@GetMapping(value = "/profiles")
	public List<Profiles> getAllProfiles() {
		return ps.getAllProfiles();
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping(value = "/profiles")
	public Response updateProfiles(@RequestBody Profiles profiles) {
		return ps.updateProfiles(profiles);
	}
}
