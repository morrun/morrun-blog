package com.morrun.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
