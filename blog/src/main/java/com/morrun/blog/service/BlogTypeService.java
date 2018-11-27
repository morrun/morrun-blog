package com.morrun.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.BlogType;
import com.morrun.blog.dao.BlogTypeDao;

@Service
public class BlogTypeService {
	@Autowired
	private BlogTypeDao btd;
	
	public List<BlogType> getAllBlogTypes() {
		return btd.findAll();
	}
}
