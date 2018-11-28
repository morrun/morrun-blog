package com.morrun.blog.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morrun.blog.beans.Comment;
import com.morrun.blog.http.Response;
import com.morrun.blog.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@GetMapping(value = "/comments")
	public List<Comment> getAllComments() {
		return cs.getAllComments();
	}
	@GetMapping(value = "/comments/{id}")
	public List<Comment> getCommentsByBlogId(@PathVariable(name = "id") Long blogId) {
		return cs.getCommentsByBlogId(blogId);
	}
	@PostMapping(value = "/comments")
	public Response addComment(@RequestBody Comment comment) {
		comment.setCreateDate(new Date());
		comment.setUpdateDate(new Date());
		return cs.addComment(comment);
	}
	@GetMapping(value = "/comments/modify/{id}")
	public Comment getCommentsByCommentId(@PathVariable(name = "id") Long commentId) {
		return cs.getByCommentId(commentId);
	}
	@DeleteMapping("/comments/{id}")
	public Response deleteById(@PathVariable Long id) {
		return cs.deleteById(id);
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/comments")
	public Response updateComment(@RequestBody Comment comment) {
		return cs.updateComment(comment);
	}
}
