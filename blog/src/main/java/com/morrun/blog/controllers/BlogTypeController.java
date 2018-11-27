package com.morrun.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morrun.blog.beans.BlogType;
import com.morrun.blog.service.BlogTypeService;

@RestController
public class BlogTypeController {

	@Autowired
	private BlogTypeService bts;
	
	@GetMapping("/blogTypes")
	public List<BlogType> getAllBlogType() {
		return bts.getAllBlogTypes();
	}
}
