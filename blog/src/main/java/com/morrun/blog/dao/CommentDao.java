package com.morrun.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {
	List<Comment> findByBlogId(Long blogId);
}
