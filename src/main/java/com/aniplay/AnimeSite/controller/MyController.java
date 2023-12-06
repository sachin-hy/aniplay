package com.aniplay.AnimeSite.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniplay.AnimeSite.dto.CommentWithUserNameDTO;
import com.aniplay.AnimeSite.entities.UserDetail;
import com.aniplay.AnimeSite.entities.VedioComment;
import com.aniplay.AnimeSite.services.UserServices;


import jakarta.servlet.http.HttpSession;

@RestController

public class MyController {

  @Autowired	
  private UserServices userservices;
	

  @PostMapping(path="/register",consumes="application/json") 
  public ResponseEntity<HttpStatus> adduser(@RequestBody UserDetail user,
		                                     HttpSession session)
  {  
	  java.sql.Date currentdate=new java.sql.Date(new Date().getTime());
	  user.setRegisterdate(currentdate); 
	  
	  UserDetail user2=new UserDetail();
	  user2.setEmail(user.getEmail());
	  session.setAttribute("userSession", user2);
	  
	  return this.userservices.addUser(user);
	  
  }
  
  
  
  @PostMapping(path="/login",consumes="application/json")
  public ResponseEntity<HttpStatus> checklogindetail(@RequestBody UserDetail user,
		                                             HttpSession session)
  {
	  
	  String email=user.getEmail();
	  System.out.println("email = "+ email);
	  String password=user.getPassword();
	  System.out.println("password = "+ password);
	  
	  UserDetail user2=new UserDetail();
	  user2.setEmail(user.getEmail());
	  session.setAttribute("userSession", user2);
	  
	  return this.userservices.checkstatus(email,password);
  }

  
  
  @PostMapping(path="/comment",consumes="application/json")
  public ResponseEntity<HttpStatus> saveComment(@RequestBody VedioComment comment,
		                                         HttpSession session)
  {
	 if( session.getAttribute("userSession")!=null)
	 {
		 
		 comment.setUser((UserDetail)session.getAttribute("userSession"));
		 java.sql.Date currentdate=new java.sql.Date(new Date().getTime());
		 comment.setCommentDate(currentdate);
		 return this.userservices.addcomment(comment);
	 }
	 else {
		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	 }
  }
  
  
  @GetMapping("/comments/{videoId}")
  public List<CommentWithUserNameDTO> getAllComments(@PathVariable String videoId)
  {
	  return userservices.getAllComments(videoId);
  }
  
}
