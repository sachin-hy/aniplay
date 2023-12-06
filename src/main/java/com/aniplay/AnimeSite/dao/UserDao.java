package com.aniplay.AnimeSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aniplay.AnimeSite.entities.UserDetail;

public interface UserDao extends JpaRepository<UserDetail,String> {

}
