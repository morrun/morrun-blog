package com.morrun.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.BlogType;

public interface BlogTypeDao extends JpaRepository<BlogType, Long> {
	public BlogType findByType(String type);
}
