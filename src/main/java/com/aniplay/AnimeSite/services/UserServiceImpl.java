package com.aniplay.AnimeSite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniplay.AnimeSite.dao.UserDao;
import com.aniplay.AnimeSite.dao.VedioDao;
import com.aniplay.AnimeSite.dto.CommentWithUserNameDTO;
import com.aniplay.AnimeSite.entities.UserDetail;
import com.aniplay.AnimeSite.entities.VedioComment;

@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private VedioDao vediodao;
	
	@Override
	public ResponseEntity<HttpStatus>  addUser(UserDetail user) {
		// TODO Auto-generated method stub
		userdao.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HttpStatus> checkstatus(String email, String password) {
		// TODO Auto-generated method stub
		
	   UserDetail user= userdao.findById(email).orElse(null);
	   if(user!=null)
	   {
		   if(password.equals(user.getPassword()))
		   {
			   return new ResponseEntity<>(HttpStatus.OK);
		   }else {
			   return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		   }
	   }
	   else {
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	   
		
	}

	
	
	@Override
	public ResponseEntity<HttpStatus> addcomment(VedioComment comment) {
		// TODO Auto-generated method stub
		
	     vediodao.save(comment);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@Override
	public List<CommentWithUserNameDTO> getAllComments(String videoId) {
		// TODO Auto-generated method stub
		return vediodao. findCommentsWithUserName(videoId);

	}

	

	
}
