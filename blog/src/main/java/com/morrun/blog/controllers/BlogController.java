package com.morrun.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morrun.blog.beans.Blog;
import com.morrun.blog.http.Response;
import com.morrun.blog.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	private BlogService bs;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(value = "/blogs")
	public Response addBlog(@RequestBody Blog blog) {
		return bs.addBlog(blog);
	}
	
	@GetMapping(value = "/blogs")
	public List<Blog> getAllBlog() {
		return bs.getAllBlog();
	}
	@GetMapping(value = "/blogs/pages/{type}")
	public Page<Blog> getBlogs(@PathVariable String type,Pageable pageable) {
		return bs.getBlogs(type, pageable);
	}
	@GetMapping(value = "/blogs/{id}")
	public Blog getBlogById(@PathVariable Long id) {
		return bs.getBlogById(id);
	}
	@PutMapping(value = "/blogs/{id}")
	public Response updateBlog(@RequestBody Blog blog, @PathVariable Long id) {
		return bs.updateBlog(blog,id);
	}
}

