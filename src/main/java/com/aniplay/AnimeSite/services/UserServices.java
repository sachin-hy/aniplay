package com.aniplay.AnimeSite.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aniplay.AnimeSite.dto.CommentWithUserNameDTO;
import com.aniplay.AnimeSite.entities.UserDetail;
import com.aniplay.AnimeSite.entities.VedioComment;

public interface UserServices {

	public ResponseEntity<HttpStatus> addUser(UserDetail user);

	public ResponseEntity<HttpStatus> checkstatus(String email, String password);

	public ResponseEntity<HttpStatus> addcomment(VedioComment comment);

	public List<CommentWithUserNameDTO> getAllComments(String videoId);

	

	
}
