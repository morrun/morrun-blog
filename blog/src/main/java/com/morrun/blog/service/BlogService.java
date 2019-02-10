package com.morrun.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.Blog;
import com.morrun.blog.beans.BlogType;
import com.morrun.blog.beans.Comment;
import com.morrun.blog.dao.BlogDao;
import com.morrun.blog.dao.BlogTypeDao;
import com.morrun.blog.http.Response;

@Service
public class BlogService {
	@Autowired
	private BlogDao bd;
	@Autowired
	private BlogTypeDao btd;
	public Response addBlog(Blog blog) {
		try {
			blog.setComments(new ArrayList<Comment>());
			blog.setUserId(1);
			blog.setCreateDate(new Date());
			blog.setUpdateDate(new Date());
			blog.setType(btd.findByType(blog.getType().getType()));
			bd.save(blog);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false,e.getStackTrace().toString());
		}		
	}
	public Response updateBlog(Blog blog, Long id) {
		try {
//			Blog b = bd.findById(id).get();
//			b.setContent(blog.getContent());
//			b.setUpdateDate(new Date());
//			b.setTitle(blog.getTitle());
//			b.setLike(blog.getLike());
//			b.setUnlike(blog.getUnlike());
//			b.getType().setType(blog.getType().getType());
//			b.setComments(blog.getComments());
//			b.setCreateDate(blog.getCreateDate());
//			b.setUserId(blog.getUserId());
			blog.setUpdateDate(new Date());
			bd.save(blog);
			return new Response(true);
		}catch (Exception e) {
			return new Response(false,e.getStackTrace().toString());
		}
	}
	public List<Blog> getAllBlog() {
		return bd.findAll();
	}
	public Blog getBlogById(Long id) {
		return bd.findById(id).get();
	}
	public Page<Blog> getBlogs(String type, Pageable pageable){
		BlogType blogType = btd.findByType(type);
		return bd.findByTypeId(blogType.getId(),pageable);
	}
}
