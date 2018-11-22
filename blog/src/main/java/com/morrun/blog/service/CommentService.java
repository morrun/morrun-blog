package com.morrun.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.Blog;
import com.morrun.blog.beans.Comment;
import com.morrun.blog.dao.BlogDao;
import com.morrun.blog.dao.CommentDao;
import com.morrun.blog.http.Response;

@Service
public class CommentService {
	@Autowired
	private CommentDao cd;
	@Autowired
	private BlogDao bd;
	
	public List<Comment> getAllComments() {
		return cd.findAll();
	}
	public Response addComment(Comment comment) {
		cd.save(comment);
		return new Response(true);
	}
	public List<Comment> getCommentsByBlogId(Long blogId) {
		return cd.findByBlogId(blogId);
	}
}
