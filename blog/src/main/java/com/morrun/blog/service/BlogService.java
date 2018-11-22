package com.morrun.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.Blog;
import com.morrun.blog.dao.BlogDao;
import com.morrun.blog.http.Response;

@Service
public class BlogService {
	@Autowired
	private BlogDao bd;
	
	public Response addBlog(Blog blog) {
		bd.save(blog);
		return new Response(true);
	}
	
	public List<Blog> getAllBlog() {
		return bd.findAll();
	}
}
