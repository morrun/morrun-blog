package com.morrun.blog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.Blog;

public interface BlogDao extends JpaRepository<Blog, Long> {
	Page<Blog> findByTypeId(Long typeId, Pageable pageable);
}
