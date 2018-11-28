package com.morrun.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morrun.blog.beans.Profiles;

public interface ProfilesDao extends JpaRepository<Profiles, Long> {

}
