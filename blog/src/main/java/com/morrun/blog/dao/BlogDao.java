package com.morrun.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.Blog;

public interface BlogDao extends JpaRepository<Blog, Integer> {

}
