package com.morrun.blog.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morrun.blog.beans.Comment;
import com.morrun.blog.dao.CommentDao;
import com.morrun.blog.http.Response;

@Service
public class CommentService {
	@Autowired
	private CommentDao cd;

	
	public List<Comment> getAllComments() {
		return cd.findAll();
	}
	public Response addComment(Comment comment) {
		try {
			cd.save(comment);
			return new Response(true);
		} catch(Exception e) {
			return new Response(false,e.getStackTrace().toString());
		}
		
	}
	public List<Comment> getCommentsByBlogId(Long blogId) {
		return cd.findByBlogId(blogId);
	}
	public Response deleteById(Long id) {
		try {
//			if (cd.findById(id).get() == null) {
//				System.out.println(cd.findById(id));
//			}
			cd.deleteById(id);
			return new Response(true);
		}catch (Exception e) {
			return new Response(false);
		}
		
	}
	public Comment getByCommentId(Long id) {
		return cd.findById(id).get();
	}
	public Response updateComment(Comment comment) {
		try {
			comment.setUpdateDate(new Date());
			cd.save(comment);
			return new Response(true);
		}catch (Exception e) {
			return new Response(false, e.getStackTrace().toString());
		}
	}
}
